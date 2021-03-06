package com.wikia.meownjik.shibenitsa;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wikia.meownjik.shibenitsa.database.CRUD;
import com.wikia.meownjik.shibenitsa.database.CategoryModel;
import com.wikia.meownjik.shibenitsa.database.DBHelper;
import com.wikia.meownjik.shibenitsa.database.WordModel;

import java.util.ArrayList;

public class EditWordFragment extends DialogFragment {
    private View dialogView;

    private EditText wordField;
    private EditText descriptionField;
    private Spinner wordCategory;

    private WordModel word;
    private DBHelper dbHelper;

    public static EditWordFragment newInstance(WordModel word) {
        EditWordFragment f = new EditWordFragment();
        Gson gson = new Gson();

        Bundle args = new Bundle();
        args.putString("word", gson.toJson(word, WordModel.class));
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gson gson = new Gson();
        word = gson.fromJson(getArguments().getString("word"), WordModel.class);
        dbHelper = new DBHelper(getContext());
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(MainActivity.TAG, "EditWordFragment.onCreateDialog()");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        dialogView = inflater.inflate(R.layout.fragment_edit_word, null); //Must save this view
        builder.setView(dialogView)
                // Add action buttons
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        saveChanges(id);
                        refreshAdapter();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditWordFragment.this.getDialog().cancel();
                    }
                });

        wordField = (EditText) dialogView.findViewById(R.id.wordCaption);
        descriptionField = (EditText) dialogView.findViewById(R.id.wordDescription);
        wordCategory = (Spinner) dialogView.findViewById(R.id.wordCategory);

        return builder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(MainActivity.TAG, "EditWordFragment.onCreateView()");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_word, container, false);

        wordField.setText(word.getWord() != null ? word.getWord() : "");
        descriptionField.setText(word.getDescription() != null ? word.getDescription() : "");

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<CategoryModel> cats = CRUD.selectAllCategories(db);
        ArrayAdapter<CategoryModel> arrayAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, cats);
        wordCategory.setAdapter(arrayAdapter);

        if(word.getCategory() != null) {
            int spinnerPosition;
            //Doesn't work through adapter.getPosition since it compares objects, not strings
            for (spinnerPosition = 0; spinnerPosition < cats.size(); spinnerPosition++) {
                if(cats.get(spinnerPosition).toString().equals(word.getCategory().toString())) {
                    break;
                }
            }
            Log.d(MainActivity.TAG, "Category: " + word.getCategory()
                    + ", spinnerPosition = " + spinnerPosition);
            wordCategory.setSelection(spinnerPosition);
        }
        db.close();

        return view;
    }

    private void refreshAdapter() {
        try {
            WordFragment wf = (WordFragment) ((WordsListActivity) getContext()).getSupportFragmentManager()
                    .findFragmentById(R.id.fragment_words);
            wf.refreshAdapter();
        }
        catch (ClassCastException er) {
            Log.w(MainActivity.TAG, "Used WordsListActivity.refreshAdapter within another activity");
        }
    }

    private void saveChanges(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int wordId = word.getId();
        word = new WordModel(wordId, wordField.getText().toString(),
                CRUD.selectAllCategories(db).get(wordCategory.getSelectedItemPosition()),
                descriptionField.getText().toString());
        if (wordId > 0 && word.getWord().length() > 0) {
            if(InputWordActivity.validateWord(getContext(),
                    wordField.getText().toString(), word.getLang())) {
                CRUD.updateWords(db, wordId, word.getWord().toLowerCase(),
                        word.getCategory().getName(), word.getLang().getLangName(),
                        word.getDescription());
                Toast.makeText(getContext(), "Saving changes", Toast.LENGTH_SHORT).show();
            }
        }
        else if (word.getWord().length() == 0) {
            CRUD.deleteFromWords(db, word.getId());
            Toast.makeText(getContext(), "The word deleted", Toast.LENGTH_SHORT).show();
        }
        else {
            if(InputWordActivity.validateWord(getContext(),
                    wordField.getText().toString(), word.getLang())) {
                CRUD.insertIntoWords(db, word.getWord().toLowerCase(),
                        word.getCategory().getName(), word.getLang().getLangName(),
                        word.getDescription());
                Toast.makeText(getContext(), "New word saved", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
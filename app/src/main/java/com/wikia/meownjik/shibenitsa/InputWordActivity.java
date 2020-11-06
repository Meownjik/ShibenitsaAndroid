package com.wikia.meownjik.shibenitsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wikia.meownjik.shibenitsa.businesslogic.Languages;
import com.wikia.meownjik.shibenitsa.businesslogic.MessagesEn;
import com.wikia.meownjik.shibenitsa.businesslogic.WordHandler;

public class InputWordActivity extends AppCompatActivity {
    private static final String TAG = "shibenitsaLogs";
    private Button ok;
    private Spinner langs;
    private EditText wordInput;
    private ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_word);

        Bundle passedData = getIntent().getExtras();
        int numOfPlayers = passedData.getInt("players", 0);
        Log.d(TAG,"Players: " + numOfPlayers);

        initComponents();
        handlePassedData();
        initListeners();
        Log.d(TAG,"InputWordActivity onCreate() done ");
    }

    private void handlePassedData() {
        Bundle passedData = getIntent().getExtras();
        int numOfPlayers = passedData.getInt("players", 0);
        Log.d(TAG,"Players: " + numOfPlayers);
        long langDropdownSelectionId = passedData.getLong("lang", 0);
        Log.d(TAG,"Language ID: " + langDropdownSelectionId);
        langs.setSelection((int) langDropdownSelectionId);
    }

    private void initComponents() {
        ok = (Button) findViewById(R.id.buttonOk);
        wordInput = (EditText) findViewById(R.id.editTextWord);
        picture = (ImageView) findViewById(R.id.picture);

        langs = (Spinner) findViewById(R.id.dropdownLang);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.supportedLanguages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langs.setAdapter(adapter);
    }

    private void initListeners() {
        ok.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        WordHandler wordHandler = new WordHandler(getCurrentLanguage());
                        String word = wordInput.getText().toString();
                        Log.d(TAG, "The word is: '" + word + "'");
                        if(!wordHandler.validateLength(word)) {
                            Toast.makeText(InputWordActivity.this,
                                    MessagesEn.WORD_INVALID_LENGTH.msg(),
                                    Toast.LENGTH_LONG).show();
                        }
                        else if(!wordHandler.validateSpecialSymbols(word)) {
                            Toast.makeText(InputWordActivity.this,
                                    MessagesEn.WORD_INVALID_SYMBOLS.msg(),
                                    Toast.LENGTH_LONG).show();
                        }
                        else if(!wordHandler.validateLetters(word)) {
                            Toast.makeText(InputWordActivity.this,
                                    MessagesEn.WORD_INVALID_LANGUAGE.msg(),
                                    Toast.LENGTH_LONG).show();
                        }
                        else {
                            Intent intent = new Intent(InputWordActivity.this,
                                    GameActivity.class);
                            intent.putExtra("lang", langs.getSelectedItem().toString());
                            intent.putExtra("word", word);
                            startActivity(intent);
                            Toast.makeText(InputWordActivity.this,
                                    "Ready for a game!",
                                    Toast.LENGTH_LONG).show();
                        }
                        Log.d(TAG,"onClick() buttonOk done");
                    }
                }
        );

        langs.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String lang = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(InputWordActivity.this, lang + " language selected",
                                Toast.LENGTH_LONG).show();
                        Log.d(TAG,"onItemSelected() dropdownLang done, chosen " + lang);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Toast.makeText(InputWordActivity.this, "No language selected",
                                Toast.LENGTH_LONG).show();
                        Log.d(TAG,"onItemSelected() dropdownLang done, nothing chosen");
                    }
                }
        );
    }

    private Languages getCurrentLanguage() {
        Log.d(TAG, "Current language: '" + langs.getSelectedItem().toString() + "'");
        return Languages.getByName(langs.getSelectedItem().toString());
    }
}
package com.wikia.meownjik.shibenitsa;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class LettersUkFragment extends Fragment implements View.OnClickListener {
    //TODO update letters IDs to be ukrainian
    // (now russian ones used as a template, and only button text changed)
    Button buttonA;
    Button buttonB;
    Button buttonV;
    Button buttonG;
    Button buttonD;
    Button buttonYe;
    Button buttonYo;
    Button buttonZh;
    Button buttonZ;
    Button buttonI;
    Button buttonJ;
    Button buttonK;
    Button buttonL;
    Button buttonM;
    Button buttonN;
    Button buttonO;
    Button buttonP;
    Button buttonR;
    Button buttonS;
    Button buttonT;
    Button buttonU;
    Button buttonF;
    Button buttonH;
    Button buttonTs;
    Button buttonCh;
    Button buttonSh;
    Button buttonShch;
    Button buttonSoftSign;
    Button buttonY;
    Button buttonHardSign;
    Button buttonE;
    Button buttonYu;
    Button buttonYa;

    GameActivity gameActivity;

    public LettersUkFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        Log.d(GameActivity.TAG, "LettersUkFragment onAttach()");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(GameActivity.TAG, "LettersUkFragment onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(GameActivity.TAG, "LettersUkFragment onCreateView()");

        View view = inflater.inflate(R.layout.fragment_letters_uk, container, false);
        initButtons(view);
        initButtonsOnClick();

        return view;
    }

    private void initButtons(View view) {
        buttonA = view.findViewById(R.id.buttonA);
        buttonB = view.findViewById(R.id.buttonB);
        buttonV = view.findViewById(R.id.buttonV);
        buttonG = view.findViewById(R.id.buttonG);
        buttonD = view.findViewById(R.id.buttonD);
        buttonYe = view.findViewById(R.id.buttonYe);
        buttonYo = view.findViewById(R.id.buttonYo);
        buttonZh = view.findViewById(R.id.buttonZh);
        buttonZ = view.findViewById(R.id.buttonZ);
        buttonI = view.findViewById(R.id.buttonI);
        buttonJ = view.findViewById(R.id.buttonJ);
        buttonK = view.findViewById(R.id.buttonK);
        buttonL = view.findViewById(R.id.buttonL);
        buttonM = view.findViewById(R.id.buttonM);
        buttonN = view.findViewById(R.id.buttonN);
        buttonO = view.findViewById(R.id.buttonO);
        buttonP = view.findViewById(R.id.buttonP);
        buttonR = view.findViewById(R.id.buttonR);
        buttonS = view.findViewById(R.id.buttonS);
        buttonT = view.findViewById(R.id.buttonT);
        buttonU = view.findViewById(R.id.buttonU);
        buttonF = view.findViewById(R.id.buttonF);
        buttonH = view.findViewById(R.id.buttonH);
        buttonTs = view.findViewById(R.id.buttonTs);
        buttonCh = view.findViewById(R.id.buttonCh);
        buttonSh = view.findViewById(R.id.buttonSh);
        buttonShch = view.findViewById(R.id.buttonShch);
        buttonSoftSign = view.findViewById(R.id.buttonSoftSign);
        buttonY = view.findViewById(R.id.buttonY);
        buttonHardSign = view.findViewById(R.id.buttonHardSign);
        buttonE = view.findViewById(R.id.buttonE);
        buttonYu = view.findViewById(R.id.buttonYu);
        buttonYa = view.findViewById(R.id.buttonYa);
    }

    private void initButtonsOnClick() {
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonV.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonYe.setOnClickListener(this);
        buttonYo.setOnClickListener(this);
        buttonZh.setOnClickListener(this);
        buttonZ.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonJ.setOnClickListener(this);
        buttonK.setOnClickListener(this);
        buttonL.setOnClickListener(this);
        buttonM.setOnClickListener(this);
        buttonN.setOnClickListener(this);
        buttonO.setOnClickListener(this);
        buttonP.setOnClickListener(this);
        buttonR.setOnClickListener(this);
        buttonS.setOnClickListener(this);
        buttonT.setOnClickListener(this);
        buttonU.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonH.setOnClickListener(this);
        buttonTs.setOnClickListener(this);
        buttonCh.setOnClickListener(this);
        buttonSh.setOnClickListener(this);
        buttonShch.setOnClickListener(this);
        buttonSoftSign.setOnClickListener(this);
        buttonY.setOnClickListener(this);
        buttonHardSign.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonYu.setOnClickListener(this);
        buttonYa.setOnClickListener(this);
    }

    private void restoreButtonsState() {
        buttonA.setEnabled(gameActivity.isLetterNotTried(buttonA.getText().toString()));
        buttonB.setEnabled(gameActivity.isLetterNotTried(buttonB.getText().toString()));
        buttonV.setEnabled(gameActivity.isLetterNotTried(buttonV.getText().toString()));
        buttonG.setEnabled(gameActivity.isLetterNotTried(buttonG.getText().toString()));
        buttonD.setEnabled(gameActivity.isLetterNotTried(buttonD.getText().toString()));
        buttonYe.setEnabled(gameActivity.isLetterNotTried(buttonYe.getText().toString()));
        buttonYo.setEnabled(gameActivity.isLetterNotTried(buttonYo.getText().toString()));
        buttonZh.setEnabled(gameActivity.isLetterNotTried(buttonZh.getText().toString()));
        buttonZ.setEnabled(gameActivity.isLetterNotTried(buttonZ.getText().toString()));
        buttonI.setEnabled(gameActivity.isLetterNotTried(buttonI.getText().toString()));
        buttonJ.setEnabled(gameActivity.isLetterNotTried(buttonJ.getText().toString()));
        buttonK.setEnabled(gameActivity.isLetterNotTried(buttonK.getText().toString()));
        buttonL.setEnabled(gameActivity.isLetterNotTried(buttonL.getText().toString()));
        buttonM.setEnabled(gameActivity.isLetterNotTried(buttonM.getText().toString()));
        buttonN.setEnabled(gameActivity.isLetterNotTried(buttonN.getText().toString()));
        buttonO.setEnabled(gameActivity.isLetterNotTried(buttonO.getText().toString()));
        buttonP.setEnabled(gameActivity.isLetterNotTried(buttonP.getText().toString()));
        buttonR.setEnabled(gameActivity.isLetterNotTried(buttonR.getText().toString()));
        buttonS.setEnabled(gameActivity.isLetterNotTried(buttonS.getText().toString()));
        buttonT.setEnabled(gameActivity.isLetterNotTried(buttonT.getText().toString()));
        buttonU.setEnabled(gameActivity.isLetterNotTried(buttonU.getText().toString()));
        buttonF.setEnabled(gameActivity.isLetterNotTried(buttonF.getText().toString()));
        buttonH.setEnabled(gameActivity.isLetterNotTried(buttonH.getText().toString()));
        buttonTs.setEnabled(gameActivity.isLetterNotTried(buttonTs.getText().toString()));
        buttonCh.setEnabled(gameActivity.isLetterNotTried(buttonCh.getText().toString()));
        buttonSh.setEnabled(gameActivity.isLetterNotTried(buttonSh.getText().toString()));
        buttonShch.setEnabled(gameActivity.isLetterNotTried(buttonShch.getText().toString()));
        buttonSoftSign.setEnabled(gameActivity.isLetterNotTried(buttonSoftSign.getText().toString()));
        buttonY.setEnabled(gameActivity.isLetterNotTried(buttonY.getText().toString()));
        buttonHardSign.setEnabled(gameActivity.isLetterNotTried(buttonHardSign.getText().toString()));
        buttonE.setEnabled(gameActivity.isLetterNotTried(buttonE.getText().toString()));
        buttonYu.setEnabled(gameActivity.isLetterNotTried(buttonYu.getText().toString()));
        buttonYa.setEnabled(gameActivity.isLetterNotTried(buttonYa.getText().toString()));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gameActivity = (GameActivity) getActivity();

        Log.d(GameActivity.TAG, "LettersUkFragment onActivityCreated()");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(GameActivity.TAG, "LettersUkFragment onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(GameActivity.TAG, "LettersUkFragment onResume()");
        restoreButtonsState(); //Only here Activity.onRestoreInstanceState is done
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Button button = (Button) view.findViewById(id);
        String letter = button.getText().toString();
        button.setEnabled(false);
        try {
            gameActivity.tryLetter(letter);
        }
        catch (IllegalArgumentException er) {
            Log.e(GameActivity.TAG, er.toString());
        }
    }
}
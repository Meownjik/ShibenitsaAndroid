package com.wikia.meownjik.shibenitsa;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LettersRuFragment extends Fragment implements View.OnClickListener {
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

    public LettersRuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context activity) {
        //public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(GameActivity.TAG, "LettersRuFragment onAttach()");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(GameActivity.TAG, "LettersRuFragment onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        gameActivity = (GameActivity) getActivity();

        Log.d(GameActivity.TAG, "LettersRuFragment onCreateView()");

        View view = inflater.inflate(R.layout.fragment_letters_ru, container, false);
        buttonA = view.findViewById(R.id.buttonA);
        buttonB = view.findViewById(R.id.buttonB);
        buttonV = view.findViewById(R.id.buttonV);
        buttonG = view.findViewById(R.id.buttonG);
        buttonD = view.findViewById(R.id.buttonD);
        buttonYe = view.findViewById(R.id.buttonYe);
        buttonYo = view.findViewById(R.id.buttonYo);
        buttonZh =view.findViewById(R.id.buttonZh);
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

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(GameActivity.TAG, "LettersRuFragment onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(GameActivity.TAG, "LettersRuFragment onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(GameActivity.TAG, "LettersRuFragment onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(GameActivity.TAG, "LettersRuFragment onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(GameActivity.TAG, "LettersRuFragment onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(GameActivity.TAG, "LettersRuFragment onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(GameActivity.TAG, "LettersRuFragment onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(GameActivity.TAG, "LettersRuFragment onDetach()");
    }



    private void initListeners() {
        Button b = (Button) getView().findViewById(R.id.buttonA);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Button button = (Button) view.findViewById(id);
        String letter = button.getText().toString();
        Log.d(GameActivity.TAG, "id = "+ id + ", letter = " + letter);
        button.setEnabled(false);
        gameActivity.tryLetter(letter);
    }
}
package com.marlonncarvalhosa.mamaeeuquero.fragments;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.marlonncarvalhosa.mamaeeuquero.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    private TextView countdownText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftinMilliseconds = 600000; //10m
    private boolean timerRunning;


    public InicioFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_inicio, container, false);
        idcampo(view);
        metodbutton();
        return  view;

    }

    public void idcampo (View view){

        countdownText = view.findViewById(R.id.countdown_text);
        countdownButton = view.findViewById(R.id.countdown_button);

    }

    private void metodbutton() {

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startStop();

            }
        });
    }

    public void startStop(){

        if (timerRunning) {

            stopTimer();

        } else {

            startTimer();
        }

    }

    public void startTimer() {

        countDownTimer = new CountDownTimer(timeLeftinMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) { // No video manda colocar 1 onde tá escrito millisUntilFinished, mas nõa funciona

                timeLeftinMilliseconds = 1;
                updateTimer();

            }

            @Override
            public void onFinish() {

            }

        }.start();

        countdownButton.setText("pause");
        timerRunning = true;

    }

    public void stopTimer() {

        countDownTimer.cancel();
        countdownButton.setText("start");
        timerRunning = false;

    }

    public void updateTimer(){

        int minutes = (int) timeLeftinMilliseconds / 60000;
        int seconds = (int) timeLeftinMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);

    }
}

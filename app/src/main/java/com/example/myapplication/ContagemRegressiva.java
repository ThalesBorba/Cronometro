package com.example.myapplication;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class ContagemRegressiva extends CountDownTimer {

    private static final int TOTAL_MILLIS = 25 * 60 * 1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;
    private static final String TIME_FORMAT = "%02d:%02d";

    private TextView remainingTimeText;

    public ContagemRegressiva(TextView remainingTimeText) {
        super(TOTAL_MILLIS, COUNT_DOWN_INTERVAL);
        this.remainingTimeText = remainingTimeText;
    }

    @Override
    public void onTick(long time) {
        remainingTimeText.setText(String.format(
                TIME_FORMAT,
                TimeUnit.MILLISECONDS.toMinutes(time),
                TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))));
    }

    @Override
    public void onFinish() {
        remainingTimeText.setText("0");
    }

}




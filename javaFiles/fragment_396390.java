package com.so.chilledrat.chronoexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ChronoExampleActivity extends Activity {
    Chronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        mChronometer = new Chronometer(this);
        layout.addView(mChronometer);

        Button startButton = new Button(this);
        startButton.setText("Start");
        startButton.setOnClickListener(mStartListener);
        layout.addView(startButton);

        Button stopButton = new Button(this);
        stopButton.setText("Stop");
        stopButton.setOnClickListener(mStopListener);
        layout.addView(stopButton);

        Button resetButton = new Button(this);
        resetButton.setText("Reset");
        resetButton.setOnClickListener(mResetListener);
        layout.addView(resetButton);

        Button switchButton = new Button(this);
        switchButton.setText("Switch Activity");
        switchButton.setOnClickListener(mSwitchListener);
        layout.addView(switchButton);

        setContentView(layout);
    }

    private void showElapsedTime() {
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        Toast.makeText(this, "Elapsed milliseconds: " + elapsedMillis, Toast.LENGTH_SHORT).show();
    }

    View.OnClickListener mStartListener = new OnClickListener() {
        public void onClick(View v) {
            mChronometer.start();
            showElapsedTime();
        }
    };

    View.OnClickListener mStopListener = new OnClickListener() {
        public void onClick(View v) {
            mChronometer.stop();
            showElapsedTime();
        }
    };

    View.OnClickListener mResetListener = new OnClickListener() {
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime());
            showElapsedTime();
        }
    };

    View.OnClickListener mSwitchListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(ChronoExampleActivity.this.getBaseContext(), OtherActivity.class);
            startActivityForResult(myIntent, 0);
        }
    };
}
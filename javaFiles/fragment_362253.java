package com.ultraman11.timertest;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int numCounter = 0;
    public boolean counting = false;

    TextView counter;
    TextView difference;
    EditText numInput;

    public int userInt;
    public int differenceInt;

    TimerTask timertask = null;
    Timer timer = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (TextView) findViewById(R.id.counter);
        difference = (TextView) findViewById(R.id.diff);
        numInput = (EditText) findViewById(R.id.numInput);
    }

    public void resetButton(View v){
        numCounter = 0;
        difference.setText("Difference: ");
        counter.setText(Integer.toString(0));
        if(timertask!=null){
            timertask.cancel();
            timertask = null;
        }
        if(timer!=null){
            timer.cancel();
            timer = null;
        }
    }

    public void startButton(View v){
        if(timertask!=null){
            timertask.cancel();
            timertask = null;
        }
        if(timer!=null){
            timer.cancel();
            timer = null;
        }

        timer = new Timer();
        timertask = new TimerTask() {

            @Override
            public void run() {
                numCounter++;
                runOnUiThread(new Runnable() {
                    public void run() {
                        counter.setText(Integer.toString(numCounter));
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timertask, 0, 1000);
    }

    public void stopButton(View v){
        if(timertask!=null){
            timertask.cancel();
            timertask = null;
        }
        if(timer!=null){
            timer.cancel();
            timer = null;
        }

        try{
              userInt = Integer.parseInt(numInput.getText().toString());
        }catch(Exception e){
          userInt = 0;
        }            
        differenceInt = Math.abs(numCounter - userInt);
        difference.setText("Difference: " + Integer.toString(differenceInt));
    }

    @Override
    protected void onDestroy() {
        if(timertask!=null){
            timertask.cancel();
            timertask = null;
        }

        if(timer!=null){
            timer.cancel();
            timer = null;
        }
        super.onDestroy();
    }
}
package com.viralgamez.gastime;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewGame<Stopwatch> extends Activity {

    private TextView displayRandInt;
    private Button updateRandInt;
    final int MSG_START_TIMER = 0;
    final int MSG_STOP_TIMER = 1;
    final int MSG_UPDATE_TIMER = 2;

    private static final Random rand = new Random();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame);

        /* Setup your Activity */

        // Find the views (their id's should be specified in the XML layout file)
        displayRandInt = (TextView) findViewById(R.id.displayRandInt);
        updateRandInt = (Button) findViewById(R.id.updateRandInt);

        // Give the Button an onClickListener
        updateRandInt.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                int randInt = rand.nextInt(100) + 1;
                displayRandInt.setText(String.valueOf(randInt));
            }

            public void onClick2(View v) {
                if (status == false) {
                    btnStart.setText("Stop");
                    status = true;
                    new Thread(new Runnable() {
                        // run() { // This needs to be changed to an actual method signature
                        public void run() {
                            for (int i = 0; i < 500; i++) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        txtCounter.setText(String.valueOf(i));
                                    }
                                });
                                Thread.sleep(1000);
                            }
                        }
                    }).start();

                // } else if (status == true) { // Change this to just }else{
                } else {

                    btnStart.setText("Start");
                    status = false;
                    initCouner();
                // }); // This needs to be changed to the following:
                }
            }
        });
    }
}
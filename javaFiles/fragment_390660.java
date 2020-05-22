package com.example.myfirstapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity  {
    private int[] operatorButtons = {R.id.operators};
    private int[] numericButtons = {R.id.onetwothree, R.id.fourfivesix, R.id.seveneightninezero};
    private boolean  lastNumeric, stateError;
    private TextView txtScreen;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Find the TextView
    this.txtScreen = (TextView) findViewById(R.id.txtScreen);
    // Find and set OnClickListener to numeric buttons
//        setNumericOnClickListener();
        // Find and set OnClickListener to operator buttons, equal button and decimal point button
//        setOperatorOnClickListener();

    Button onetwothree = (Button) findViewById(R.id.onetwothree);
    onetwothree.setOnTouchListener(new View.OnTouchListener() {

        Handler handler = new Handler();

        int numberOfTaps = 0;
        long lastTapTimeMs = 0;
        long touchDownMs = 0;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchDownMs = System.currentTimeMillis();
                    break;
                case MotionEvent.ACTION_UP:
                    handler.removeCallbacksAndMessages(null);
                    if ((System.currentTimeMillis() - touchDownMs) > ViewConfiguration.getTapTimeout()) {
                        //it was not a tap

                        numberOfTaps = 0;
                        lastTapTimeMs = 0;
                        break;
                    }

                    if (numberOfTaps > 0
                            && (System.currentTimeMillis() - lastTapTimeMs) < ViewConfiguration.getDoubleTapTimeout()) {
                        numberOfTaps += 1;
                    } else {
                        numberOfTaps = 1;
                    }
                    lastTapTimeMs = System.currentTimeMillis();

                    if (numberOfTaps == 1) {
                        handler.postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                if (txtScreen.getText().toString() == "") {
                                    txtScreen.setText("1");
                                } else txtScreen.append("1");
                            }
                        }, ViewConfiguration.getDoubleTapTimeout());



                    }else if (numberOfTaps == 2) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (txtScreen.getText().toString() == "") {
                                    txtScreen.setText("2");
                                } else txtScreen.append("2");
                            }
                        }, ViewConfiguration.getDoubleTapTimeout());

                    } else if (numberOfTaps == 3) {
                                if (txtScreen.getText().toString() == "") {
                                    txtScreen.setText("3");
                                } else txtScreen.append("3");
                    }
            }

            return false;
        }
    });
}


private void setNumericOnClickListener() {
    // Create a common OnClickListener
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Just append/set the text of clicked button
            Button button = (Button) v;
            if (stateError) {
                // If current state is Error, replace the error message
                txtScreen.setText(button.getText());
                stateError = false;
            } else {
                // If not, already there is a valid expression so append to it
                txtScreen.append(button.getText());
            }
            // Set the flag
            lastNumeric = true;
        }
    };
    // Assign the listener to all the numeric buttons
    for (int id : numericButtons) {
        findViewById(id).setOnClickListener(listener);
    }
}

private void setOperatorOnClickListener() {
    // Create a common OnClickListener for operators
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // If the current state is Error do not append the operator
            // If the last input is number only, append the operator
            if (lastNumeric && !stateError) {
                Button button = (Button) v;
                txtScreen.append(button.getText());
                lastNumeric = false;

            }
        }
    };
    // Assign the listener to all the operator buttons
    for (int id : operatorButtons) {
        findViewById(id).setOnClickListener(listener);
    }


}
}
package com.ave;

import com.ave.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Menu extends Activity {
    ImageButton select;
    int isClicked = 0;
    ImageButton audio;
    int isClicked1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        select = (ImageButton) findViewById(R.id.select);
        select.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                if (isClicked == 0) {
                    select.setImageResource(R.drawable.select_pressed);
                    isClicked = 1;
                } else {
                    select.setImageResource(R.drawable.select);
                    isClicked = 0;
                }
            }
        });
        audio = (ImageButton) findViewById(R.id.audio);
        audio.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                if (isClicked1 == 0) {
                    audio.setImageResource(R.drawable.audio_pressed);
                    isClicked1 = 1;
                } else {
                    audio.setImageResource(R.drawable.audio);
                    isClicked1 = 0;
                }

            }
        });
    }
}
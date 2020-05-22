package com.andrew.finnandjake;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Sounds extends Activity {
private SoundManager mSoundManager;

/** Called when the activity is first created. */

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    mSoundManager = new SoundManager();
    mSoundManager.initSounds(getBaseContext());
    mSoundManager.addSound(1, R.raw.finn_whatthejugisthat);
    mSoundManager.addSound(2, R.raw.jake_dancingwithbabes);

    Button b1 = (Button)findViewById(R.id.Button1);
    b1.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            mSoundManager.playSound(1);


        }
    });

    Button b2 = (Button)findViewById(R.id.Button2);
    b2.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            mSoundManager.playSound(2);
        }
    });
}
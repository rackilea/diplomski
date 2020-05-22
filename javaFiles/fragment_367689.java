package com.example.matthew.somediaplayer;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TEST";
    private MediaPlayer mediaPlayer;
    private boolean isMediaPlayerPrepared = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying() == false) {
                    playSound();
                }
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "In onResume()");
        createAndPrepareMediaPlayer();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "In onStop()");
        mediaPlayer.release();
        isMediaPlayerPrepared = false;
    }

    @Override
    public void onPause(){
        Log.d(TAG, "In onPause()");
        super.onPause();
    }

    public void createAndPrepareMediaPlayer() {
        Log.d(TAG, "In createAndPrepareMediaPlayer()");
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        if(isMediaPlayerPrepared == false) {
            try {
                AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.test);
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        Log.d(TAG, "Media player is prepared.");
                        isMediaPlayerPrepared = true;
                        Button button = (Button) findViewById(R.id.button);
                        button.setEnabled(true);
                    }
                });
                Log.d(TAG, "Beginning to prepare media player.");
                mediaPlayer.prepareAsync();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void playSound() {

        Log.d(TAG, "In playSound()");
        if( isMediaPlayerPrepared ) {
            // Will call onFinish() after 2 seconds. Second parameter is
            // for onTick() which we don't need and can ignore.
            new CountDownTimer(2000, 2000) {

                public void onTick(long millisUntilFinished) {
                    // Do nothing...
                }

                public void onFinish() {
                    Log.d(TAG, "In onFinish()");
                    // We can't call a method like pause on an unprepared MediaPlayer instance.
                    if( isMediaPlayerPrepared ) {
                        mediaPlayer.pause();
                    } else {
                        Log.d(TAG, "Media player isn't prepared, and isn't allowed to pause.");
                    }
                }

            }.start();

            mediaPlayer.setLooping(false);
            mediaPlayer.seekTo(0); // set to beginning of track (if not already)
            mediaPlayer.start();
            Log.d(TAG, "Starting to play a sound.");
        }
    }

}
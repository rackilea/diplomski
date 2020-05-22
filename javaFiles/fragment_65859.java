package com.example.dhrupalpatel.test;
import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener{
MediaRecorder mrecorder;
boolean mStartRecording=false;

Button start, stop;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    start =(Button)findViewById(R.id.start);
    stop =(Button)findViewById(R.id.stop);
    start.setOnClickListener(this);
    stop.setOnClickListener(this);

}

private void startRec() throws IOException {
   boolean mExternalStorageAvailable = false;
    boolean mExternalStorageWriteable = false;
    String state = Environment.getExternalStorageState();

    if (Environment.MEDIA_MOUNTED.equals(state)) {
        // We can read and write the media
        mExternalStorageAvailable = mExternalStorageWriteable = true;
    } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
        // We can only read the media
        mExternalStorageAvailable = true;
        mExternalStorageWriteable = false;
    } else {
        // Something else is wrong. It may be one of many other states, but all we need
        //  to know is we can neither read nor write
        mExternalStorageAvailable = mExternalStorageWriteable = false;
    }
    File sdCardDirectory= Environment
            .getExternalStorageDirectory();
    if(mExternalStorageAvailable && !sdCardDirectory.exists())
    {
        sdCardDirectory.mkdir();
    }
    File f= new File(sdCardDirectory.getPath()+"/"+System.currentTimeMillis()+".mp3");
    if( mrecorder == null ) {
        mrecorder = new MediaRecorder();
        mrecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mrecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

        mrecorder.setOutputFile(f.getPath());
        mrecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
    }
    if(!mStartRecording) {

        try {
            mrecorder.prepare();
            mrecorder.start();
            mStartRecording = true;
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}

private void stopRec() throws IOException {

    if(mStartRecording) {
        mStartRecording = false;
        mrecorder.stop();
        mrecorder.reset();
        mrecorder.release();
        mrecorder = null;
    }
}

@Override
public void onClick(View v) {
    switch (v.getId())
    {
        case R.id.start:
            try {
                startRec();
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        case R.id.stop:
            try {
                stopRec();
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
    }

}
}
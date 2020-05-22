package com.example.audiorecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
        private static final int RECORDER_SAMPLERATE = 44100;
        private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
        private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;
        private AudioRecord recorder = null;
        private Thread recordingThread = null;
        private boolean isRecording = false;
        private String floatString = "";

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("ddMMMyyyy_HHmmss");
        String formattedDate = df.format(c.getTime());

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setButtonHandlers();
            enableButtons(false);

            int bufferSize = AudioRecord.getMinBufferSize(RECORDER_SAMPLERATE,
                    RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING); 
        }

        private void setButtonHandlers() {
            ((Button) findViewById(R.id.btnStart)).setOnClickListener(btnClick);
            ((Button) findViewById(R.id.btnStop)).setOnClickListener(btnClick);
        }

        private void enableButton(int id, boolean isEnable) {
            ((Button) findViewById(id)).setEnabled(isEnable);
        }

        private void enableButtons(boolean isRecording) {
            enableButton(R.id.btnStart, !isRecording);
            enableButton(R.id.btnStop, isRecording);
        }

        int BufferElements2Rec = 1024; // want to play 2048 (2K) since 2 bytes we use only 1024
        int BytesPerElement = 2; // 2 bytes in 16bit format

        private void startRecording() {
            final File logFile = new File("sdcard/log_"+formattedDate+".txt");
               if (!logFile.exists())
               {
                  try
                  {
                     logFile.createNewFile();
                  } 
                  catch (IOException e)
                  {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
               }

            recorder = new AudioRecord(MediaRecorder.AudioSource.MIC,
                    RECORDER_SAMPLERATE, RECORDER_CHANNELS,
                    RECORDER_AUDIO_ENCODING, BufferElements2Rec * BytesPerElement);

            recorder.startRecording();
            isRecording = true;
            recordingThread = new Thread(new Runnable() {
                public void run() {
                    writeAudioDataToFile(logFile);
                }
            }, "AudioRecorder Thread");
            recordingThread.start();
        }


        private void writeAudioDataToFile(File logFile) {
            // Write the output audio in byte

            short sData[] = new short[BufferElements2Rec];
            while (isRecording) {
                // gets the voice output from microphone to byte format

                recorder.read(sData, 0, BufferElements2Rec);
                String sDataString = "";
                double sDataMax = 0;
                for(int i=0; i<sData.length; i++){
                    if(Math.abs(sData[i])>=sDataMax){sDataMax=Math.abs(sData[i]);};
                    sDataString += "\n" + sDataMax;

                }

               try
               {
                  //BufferedWriter for performance, true to set append to file flag
                  BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true)); 
                  buf.append(sDataString);
                  buf.newLine();
                  buf.close();
               }
               catch (IOException e)
               {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
        }
        }
        private void stopRecording() {
            // stops the recording activity
            if (null != recorder) {
                isRecording = false;
                recorder.stop();
                recorder.release();
                recorder = null;
                recordingThread = null;
            }
        }

        private View.OnClickListener btnClick = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.btnStart: {
                    enableButtons(true);
                    startRecording();
                    break;
                }
                case R.id.btnStop: {
                    enableButtons(false);
                    stopRecording();
                    break;
                }
                }
            }
        };

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                finish();
            }
            return super.onKeyDown(keyCode, event);
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
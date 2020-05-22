public class ExampleActivity extends Activity implements OnClickListener {
private Button startButton;
private Button stopButton;
private MediaRecorder mediaRecorder;
private File audioFile;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_layout);
    startButton = (Button) findViewById(R.id.button1);
    startButton.setOnClickListener(this);
    startButton.setText("start");

    stopButton = (Button) findViewById(R.id.button2);
    stopButton.setOnClickListener(this);
    stopButton.setEnabled(false);
    stopButton.setText("stop");

    audioFile = new File(Environment.getExternalStorageDirectory(),
            "audio_test4.3gp");
}

// this process must be done prior to the start of recording
private void resetRecorder() {
    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
    mediaRecorder.setAudioEncodingBitRate(16);
    mediaRecorder.setAudioSamplingRate(44100);
    mediaRecorder.setOutputFile(audioFile.getAbsolutePath());

    try {
        mediaRecorder.prepare();
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Override
public void onClick(View v) {
    switch (v.getId()) {
    case R.id.button1:
        mediaRecorder = new MediaRecorder();
        resetRecorder();
        mediaRecorder.start();

        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        break;
    case R.id.button2:
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        break;
    }
}

@Override
protected void onPause() {
    super.onPause();

    if (mediaRecorder != null) {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }
}
}
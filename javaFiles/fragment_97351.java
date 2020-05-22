public class MainActivity extends Activity {
    private static final String TAG = "Demo";

    TextToSpeech myTTS;
    boolean mInitComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        Button btnSpeak = (Button)findViewById(R.id.button1);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                speakOut("You pressed the button");
            }
        });
    }

    private void speakOut(String msg) {
        if (mInitComplete) {
            int status = myTTS.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
            if (status == TextToSpeech.SUCCESS) {
                Log.i(TAG, "speakOut(): SUCCESS");
            } else {
                Log.i(TAG, "speakOut(): ERROR");
            }
        } else {
            Log.i(TAG, "speakOut(): TTS Not Initialized");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");

        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    mInitComplete = true;
                    Log.i(TAG, "onInit(): TTS Initialized");
                } else {
                    Log.i(TAG, "onInit(): TTS Init Failed");
                }
            }
        });

        speakOut("This will fail because TTS init is not complete");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");

        myTTS.shutdown();
        mInitComplete = false;
    }
}
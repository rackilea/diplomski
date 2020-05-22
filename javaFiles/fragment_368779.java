public class MainActivity extends AppCompatActivity {

    int androidAPILevel = android.os.Build.VERSION.SDK_INT;
    TextToSpeech textToSpeech;
    AudioManager audioManager;
    int currentVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                start();
            }
        });

        textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String s) {
            }
            @Override
            public void onDone(String s) {
                Log.i("XXX", "onDone() called.");
                setDefaultVolume(); // sets volume back to normal *after* speech is done.
            }
            @Override
            public void onError(String s) {
                Log.i("XXX", "onError() called.");
                setDefaultVolume(); // sets volume back to normal *after* speech is done.
            }
        });
    }

    private void start() {
        setMaxVolume();
        activateTTS("hello! hello! hello! hello! hello! hello!");
    }

    private void activateTTS(String myString) {

        if(androidAPILevel < 21){
            HashMap<String, String> params = new HashMap<>();
            params.put(TextToSpeech.Engine.KEY_PARAM_VOLUME, "1");
            params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "thisNeedsToBeSet");
            textToSpeech.speak(myString, TextToSpeech.QUEUE_FLUSH, params);
        } else{
            Bundle params = new Bundle();
            params.putFloat(TextToSpeech.Engine.KEY_PARAM_VOLUME, 1f);
            textToSpeech.speak(myString, TextToSpeech.QUEUE_FLUSH, params, "thisNeedsToBeSet");
        }

    }

    private void setMaxVolume(){
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
    }

    private void setDefaultVolume(){
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);
    }

}
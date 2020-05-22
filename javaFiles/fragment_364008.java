public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;

    String sentence = "The Quick Brown Fox Jumps Over The Lazy Dog.";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(sentence);
        tts = new TextToSpeech(this, this);

    }

    // TextToSpeech.OnInitListener (for our purposes, the "main method" of this activity)
    public void onInit(int status) {

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {

            @Override
            public void onStart(String utteranceId) {
                Log.i("XXX", "utterance started");
            }

            @Override
            public void onDone(String utteranceId) {
                Log.i("XXX", "utterance done");
            }

            @Override
            public void onError(String utteranceId) {
                Log.i("XXX", "utterance error");
            }

            @Override
            public void onRangeStart(String utteranceId,
                                     final int start,
                                     final int end,
                                     int frame) {
                Log.i("XXX", "onRangeStart() ... utteranceId: " + utteranceId + ", start: " + start
                        + ", end: " + end + ", frame: " + frame);

                // onRangeStart (and all UtteranceProgressListener callbacks) do not run on main thread
                // ... so we explicitly manipulate views on the main thread:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Spannable textWithHighlights = new SpannableString(sentence);
                        textWithHighlights.setSpan(new ForegroundColorSpan(Color.YELLOW), start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                        textView.setText(textWithHighlights);

                    }
                });

            }

        });

    }

    public void startClicked(View ignored) {

        tts.speak(sentence, TextToSpeech.QUEUE_FLUSH, null, "doesn't matter yet");

    }

}
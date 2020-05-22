public class mainj extends Activity implements OnInitListener {

private TextToSpeech myTTS;
// status check code
private int MY_DATA_CHECK_CODE = 0;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.loadscreen);
    Intent checkTTSIntent = new Intent();
    checkTTSIntent
         .setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
    startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
    Thread logoTimer = new Thread() {
        public void run() {
            try {
                try {
                    sleep(5000);
                    speakWords("loading");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                Intent menuIntent = new Intent("android.intent.action.MENU");
                startActivity(menuIntent);

            }

            finally {
                finish();
            }
        }

    };
    logoTimer.start();
}

// speak the user text
private void speakWords(String speech) {

    // speak straight away
   if(myTTS != null)
   {
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
   }
}

// act on result of TTS data check
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == MY_DATA_CHECK_CODE) {
        if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
            // the user has the necessary data - create the TTS
            myTTS = new TextToSpeech(this, this);
        } else {
            // no data - install it now
            Intent installTTSIntent = new Intent();
            installTTSIntent
                    .setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
            startActivity(installTTSIntent);
        }
    }
}

// setup TTS
public void onInit(int initStatus) {

    // check for successful instantiation
    if (initStatus == TextToSpeech.SUCCESS) {
        if (myTTS.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
            myTTS.setLanguage(Locale.US);
    } else if (initStatus == TextToSpeech.ERROR) {
        Toast.makeText(this, "Sorry! Text To Speech failed...",
                Toast.LENGTH_LONG).show();
    }
}
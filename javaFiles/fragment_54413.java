import java.util.Locale;
    import android.speech.tts.TextToSpeech;

public class TextToSpeech{

    private EditText write;
    private TextToSpeech t1;
    private Button speakbtn;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_text_to_speech );

        write = (EditText) findViewById ( R.id.editText );
        speakbtn = (Button) findViewById ( R.id.board );

  t1 = new TextToSpeech ( getApplicationContext () , new TextToSpeech.OnInitListener () {
            @Override
            public void onInit(int status) {

                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage ( Locale.ENGLISH );

                }

            }
        } );

 speakbtn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                String toSpeak = write.getText ().toString ();
                Toast.makeText ( getApplicationContext () , toSpeak , Toast.LENGTH_SHORT ).show ();
                t1.speak ( toSpeak , TextToSpeech.QUEUE_FLUSH , null );

            }
        } );

  }
    @Override
    public void onDestroy() {
        //Dont forget to shut down text to speech
        if (t1 != null) {
            t1.stop ();
            t1.shutdown ();
        }
        super.onDestroy ();
    }

}
public class Level01vraag01 extends Activity implements OnClickListener {

    int playknopvariable = 0;
    MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraaglayout);
        setupButtonClickListeners();
        mp = MediaPlayer.create(Level01vraag01.this, R.raw.mcdonalds);

    }

private void setupButtonClickListeners()
{
    ImageView playsoundButton = (ImageView) findViewById(R.id.playsoundbutton);
    playsoundButton.setOnClickListener(this);
}
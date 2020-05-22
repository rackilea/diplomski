@Override
  public boolean onCreateOptionsMenu(Menu menu) {
return super.onCreateOptionsMenu(menu);
   }


     // DictionaryActivity.class
public class DefinitionActivity extends AppCompatActivity {

    String tagalogword;
    String worddefinition;
    String cuyunoword;
    String englishword;

    int[] sounds = new int[]{R.raw.alaala,
    R.raw.araw,
    R.raw.baliw,
    R.raw.basura,
    R.raw.kaibigan,
    R.raw.kakatuwa,
    R.raw.kasunduan,
    };

     private int songPosition = 0;


    @Override
     protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_definition);


TextView wordtv = (TextView) findViewById(R.id.wordtv);
TextView definitiontv = (TextView) findViewById(R.id.definitiontv);
TextView cuyunotv = (TextView) findViewById(R.id.cuyunotv);
TextView englishtv = (TextView) findViewById(R.id.englishtv);
Button play = (Button) findViewById(R.id.playbty);



final Bundle extras = getIntent().getExtras();

if (extras != null) {

    tagalogword = extras.getString("tagword");
    wordtv.setText(tagalogword);

    worddefinition = extras.getString("definitionlabel");
    definitiontv.setText(worddefinition);

    cuyunoword = extras.getString("cuyunodefinition");
    cuyunotv.setText(cuyunoword);

    englishword = extras.getString("englishdefinition");
    englishtv.setText(englishword);

    songPosition = extras.getInt("position");  


}

play.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {

        // Play it here like
      MediaPlayer mediaPlayer=MediaPlayer.create(DictionaryActivity.class,sounds[position]);

      mediaPlayer.start();

    }
});

   }
    }
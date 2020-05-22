public class Level01vraag01 extends Activity implements OnClickListener {

    int playknopvariable = 0;
    MediaPlayer mp;
    ImageView playsoundButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraaglayout);
        setupButtonClickListeners();
        mp = MediaPlayer.create(Level01vraag01.this, R.raw.mcdonalds);

    }

    private void setupButtonClickListeners(){
        playsoundButton = (ImageView) findViewById(R.id.playsoundbutton);
        playsoundButton.setOnClickListener(this);
    }

    private void klikopplaybutton(){

        if (playknopvariable == 0){
           mp.start();
           playknopvariable = 1;
           playsoundButton.setImageResource(R.drawable.playsoundbutton);
       }else{
           mp.pause();
           playknopvariable = 0;
           playsoundButton.setImageResource(R.drawable.pause);
   }

   public void onClick(View v) {

        switch(v.getId()){
        case R.id.playsoundbutton:
            klikopplaybutton();
        break;
   }

}
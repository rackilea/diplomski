public class Langue extends Activity{
 @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.langue);
final MediaPlayer  iles= MediaPlayer.create(Langue.this, R.raw.iles);//creating iles here
final String St1 ="My topic1"
 Button But1 = (Button)findViewById(R.id.button1);
        But1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView Tv = (TextView)findViewById(R.id.textView1);
                Tv.setText(St1);
                // code to make scroll back to up, to start point.
                Tv.scrollTo(0, 0);
                iles.stop(); // in here the song will stop
                                        }
                                                     });
 final String St2="My Topic2"
Button But2 = (Button)findViewById(R.id.button2);
But2.setOnClickListener(new OnClickListener(){
    @Override
    public void onClick(View v) {
        TextView Tv = (TextView)findViewById(R.id.textView1);
        Tv.setText(St2);
        // code to make scroll back to up, to start point.
        Tv.scrollTo(0, 0);
        iles.stop(); // in here the song will stop
                                }
                                            });

final String St3="Lyrics of song iles.mp3"
Button But3 = (Button)findViewById(R.id.button3);
But3.setOnClickListener(new OnClickListener(){
@Override
public void onClick(View v) {

TextView Tv = (TextView)findViewById(R.id.textView1);
Tv.setText(St3);
//code to make scroll back to up, to start point.
Tv.scrollTo(0, 0);
//play song
iles.start();
}
                                  });
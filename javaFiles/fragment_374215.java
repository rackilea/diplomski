public class Home extends Activity {
public static MediaPlayer mediaPlayer1,mediaPlayer2;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Media Player
Runnable backgroundSound = new Runnable() {
@Override
   public void run() {
        mediaPlayer1= MediaPlayer.create(Home.this, R.raw.welcome_message);
   mediaPlayer1.start();
        mediaPlayer2= MediaPlayer.create(Home.this, R.raw.welcome_tone);
   mediaPlayer2.start();
   }
};

Thread media = new Thread(backgroundSound);
media.start();
// Media Player 

}
@Override
public void onBackPressed() 
{
   if(mediaPlayer1.isPlaying())
mediaPlayer1.stop();
if(mediaPlayer2.isPlaying())
mediaPlayer2.stop();
   super.onBackPressed();       
}
}
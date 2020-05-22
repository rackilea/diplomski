public class MyActivity extends Activity {
    MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        mMediaPlayer = MediaPlayer.create(MyActivity.this,R.raw.whistle_sound);
    }
    public void displayForWinner(String score) {
        final String FinalScore = score;
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                TextView scoreView = (TextView) findViewById(R.id.textView);
                scoreView.setText(String.valueOf(FinalScore));
            }
        });
    }
}
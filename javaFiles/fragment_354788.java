public class MainActivity extends AppCompatActivity {

    int currentPosition;
    MediaPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musicPlayer = MediaPlayer.create(this, R.raw.sound_file);

        Button startButton = (Button) findViewById(R.id.start);
        startButton.setOnClickListener(view -> musicPlayer.start());

        Button pauseButton = (Button) findViewById(R.id.pause);
        pauseButton.setOnClickListener(view -> musicPlayer.pause());
    }
}
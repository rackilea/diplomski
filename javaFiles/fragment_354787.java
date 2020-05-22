public class MainActivity extends AppCompatActivity {

    MediaPlayer musicPlayer; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listener);
        musicPlayer = MediaPlayer.create(this, R.raw.sound_file);
    }
    ...
}
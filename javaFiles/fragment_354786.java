public class MainActivity extends AppCompatActivity {

    MediaPlayer musicPlayer; 

    public MyListener() {
        musicPlayer = MediaPlayer.create(this, R.raw.sound_file);
    }
    ...
}
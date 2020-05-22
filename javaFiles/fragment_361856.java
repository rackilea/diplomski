public class MainActivity extends AppCompatActivity implements AudioManager.OnAudioFocusChangeListener {

AM.requestAudioFocus(afChangeListener <-- should have been 'this',
                // Use the music stream.
                AudioManager.STREAM_MUSIC,
                // Request permanent focus.
                AudioManager.AUDIOFOCUS_GAIN);
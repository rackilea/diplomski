public class MainActivity extends Activity implements OnTouchListener {

private MediaPlayer mediaPlayer;
LinearLayout linear;
ImageButton zero;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    linear = (LinearLayout) findViewById(R.id.layout);

    zero = (ImageButton) this.findViewById(R.id.button);
    zero.setOnTouchListener(this);

    mediaPlayer = MediaPlayer.create(this, R.raw.hino);
}

@Override
public boolean onTouch(View v, MotionEvent event)
{

    switch (event.getAction())
    {

        case MotionEvent.ACTION_DOWN:
        {
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            Toast.makeText(MainActivity.this, "clik", Toast.LENGTH_LONG).show();
            // If you want to change the image, and not the background color, use setImageResource
            zero.setImageResource(R.drawable.music_has_started_image)
        }

        break;
        case MotionEvent.ACTION_UP:
        {
            mediaPlayer.pause();
            zero.setImageResource(R.drawable.music_has_ended_image)
        }
        break;
    }

    return true;
}

}
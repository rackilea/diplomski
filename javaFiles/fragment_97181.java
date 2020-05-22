public class MainActivity extends Activity implements SurfaceHolder.Callback {

    CircleSurface surface;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surface = (CircleSurface) findViewById(R.id.surface);
        SurfaceHolder holder = surface.getHolder();
        holder.addCallback(this);

        player = MediaPlayer.create(this, R.raw.yourvideo);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        player.setDisplay(holder);
        player.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        //TODO: handle this
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //TODO: handle this
    }
}
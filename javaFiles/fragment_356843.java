public class MainActivity extends Activity {

    VideoView video_player_view;
    SurfaceView sur_view;
    MediaController media_controller;
    DisplayMetrics dm;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);\
   getInit();
    }

  public void getInit()
    {
  video_player_view = (VideoView)findViewById(R.id.videoView1);
  media_controller = new MediaController(this);
  dm = new DisplayMetrics();      
  this.getWindowManager().getDefaultDisplay().getMetrics(dm);
  int height = dm.heightPixels;
  int width = dm.heightPixels;
  video_player_view.setMinimumHeight(height);
  video_player_view.setMinimumWidth(width);
  video_player_view.setMediaController(media_controller);
  video_player_view.setVideoPath("/mnt/sdcard/a.mp4");
  video_player_view.start();  
   }
  }
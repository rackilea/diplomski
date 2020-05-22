public class VideoViewer extends Activity { 

SharedPreferences sh; 
private final Context context = this; 
private CountDownTimer cdt; 
@Override
protected void onCreate(Bundle savedInstanceState) { 
    setContentView(R.layout.videoview); 
    super.onCreate(savedInstanceState); 

    sh = PreferenceManager.getDefaultSharedPreferences(context); 

    final VideoView vv = (VideoView) findViewById(R.id.videoView1); 
    cdt = new CountDownTimer(200,200) { 

        @Override
        public void onTick(long arg0) { 
            // TODO Auto-generated method stub 

        } 

        @Override
        public void onFinish() { 
            if(vv.getCurrentPosition()>10){ 
                findViewById(R.id.relativeLayout1).setVisibility(View.GONE); 
                if(sh.getString("radio", "").equals("yes")){ 
                    findViewById(R.id.imageView1).setVisibility(View.VISIBLE); 
                }else { 
                    findViewById(R.id.imageView1).setVisibility(View.GONE); 
                } 
            } 
            else
                start(); 
        } 
    }; 
    String videoUrl = getIntent().getType(); 
    Log.e(" ..videoUrl.. ", videoUrl); 
    Uri uri = Uri.parse(videoUrl); 
    vv.setVideoURI(uri); 

    ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1); 
    pb.bringToFront(); 
    vv.setOnPreparedListener(new OnPreparedListener() { 

        @Override
        public void onPrepared(MediaPlayer mp) { 
            cdt.start(); 
            vv.start(); 
        } 
    }); 
    vv.setMediaController(new MediaController(context)); 
    vv.setOnCompletionListener(new OnCompletionListener() { 

        @Override
        public void onCompletion(MediaPlayer mp) { 
            finish(); 
        } 
    }); 
}
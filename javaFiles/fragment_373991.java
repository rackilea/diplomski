public class Splash extends Activity{   
MediaPlayer ourSong;
@Override
protected void onCreate(Bundle savedInstanceState) {
    this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
         setContentView(R.layout.splash);  

         SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());                 

         boolean without_splash_screen = getPrefs.getBoolean("without_splash_screen", true);
            if (without_splash_screen == true)
            {   
                Intent intent = new Intent(Splash.this, MainActivity.class);                                     
                startActivity(intent);
            }

    boolean splash = getPrefs.getBoolean("splash", true);       
    if(splash == true) {
        setContentView(R.layout.splash);  
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000); 
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace(); 
                }
                finally
                {
                    Intent intent = new Intent(Splash.this, MainActivity.class);                                     
                    startActivity(intent);  
                }
            }                          
        };
        timer.start();   
    }                 

    ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound); 

    SharedPreferences getPrefs1 = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    boolean music = getPrefs1.getBoolean("splash_music", true);
    if (music == true)      
    ourSong.start();

    Thread timer = new Thread(){
        public void run(){
            try{
                sleep(2000); }
              catch (InterruptedException e){
                e.printStackTrace(); }
              finally{
                  Intent intent = new Intent(Splash.this, MainActivity.class);                                     
                  startActivity(intent); }}                                 
                                };
         timer.start();   }

@Override
protected void onPause() {
            // TODO Auto-generated method stub
    super.onPause();
    ourSong.release();
    finish();
          } 
       }
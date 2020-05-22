public class Splash extends Activity implements View.OnClickListener {

MediaPlayer splashsong;
Button skipsplash;
boolean skipWait = false;

@Override
protected void onCreate(Bundle chiefsplash) {
// TODO Auto-generated method stub
super.onCreate(chiefsplash);
setContentView(R.layout.splash);

splashsong = MediaPlayer.create(Splash.this, R.raw.jingle);
splashsong.start();
skipsplash = (Button) findViewById(R.id.skipsplash);

skipsplash.setOnClickListener(this);

Thread splashtimer = new Thread() {
    int waitTime = 0;
    public void run() {
        while(waitTime < 5000 && !skipWait) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
            waitTime += 500;
        }
        switchactivity();
    }
};

splashtimer.start();
}

@Override
public void onClick(View skipbutton) {
    skipWait = true;
}

private void switchactivity() {
Intent aftersplash = new Intent("com.example.testapp.MENU");
startActivity(aftersplash);
}

@Override
protected void onPause() {

super.onPause();
splashsong.release();
finish();
}
public class Splash extends Activity {

/** Duration of wait **/
private final int SPLASH_DISPLAY_LENGTH = 3000;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.splashscreen);

Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new OnClickListener() {

        @Override

        public void onClick(View view) {

   SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME,  MODE_PRIVATE).edit();
   editor.putString("status", "clicked");
   editor.commit();

        }
    });

  SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); 

String name = prefs.getString("status", "NotClicked");


if(name.equals("clicked"){
            /* Create an Intent that will start the Menu-Activity. */
            Intent mainIntent = new Intent(Splash.this,pnbActivity.class);
            Splash.this.startActivity(mainIntent);
            Splash.this.finish();
            }
    /* New Handler to start the Menu-Activity 
     * and close this Splash-Screen after some seconds.*/
    new Handler().postDelayed(new Runnable(){
        @Override
        public void run() {

            /* Create an Intent that will start the Menu-Activity. */
            Intent mainIntent = new Intent(Splash.this,pnbActivity.class);
            Splash.this.startActivity(mainIntent);
            Splash.this.finish();

        }
    }, SPLASH_DISPLAY_LENGTH);
   }
  }
public class SplashScreen extends AppCompatActivity {
            @Override
            protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.splash_activity);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      forcedLogout();
                    }
                },5*1000);
            }
        }

            private void forcedLogout(){

                if (myPrefs.getLong(PREF_APP_CURRENT_VERSION,0) != BuildConfig.VERSION_CODE){
                    //call logout method
                 }else{
                        startActivity(new Intent(SplashScreen.this,MainActivity.class));

                        finish();
    }
}
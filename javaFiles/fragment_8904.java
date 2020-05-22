public class SplashActivity extends AppCompatActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
     new Handler().postDelayed(new Runnable(){
        @Override
        public void run() {
            Intent mainIntent = new 
            Intent(SplashActivity.this,AnotherActivity.class);
            startActivity(mainIntent);
            finish();
        }
    },3000);
   }
 }
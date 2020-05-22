public class MainActivity extends AppCompatActivity {

   TextView tv6 = findViewById(R.id.textView6);
   SharedPreferences sharedPreferences;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
      String sessionId = preferences.getString("sessionId", null);
      tv6.setText(sessionId);
   }

}
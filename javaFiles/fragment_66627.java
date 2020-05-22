public class StartActivity extends AppCompatActivity {


 public void gotocalc(View view)
 {
 Intent intent = new Intent(StartActivity.this, YourModulClass.class);
 startActivity(intent);
 }
public class MainActivity extends AppCompatActivity{

 private TextView txt;
 private Count i;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     txt = (TextView)findViewById(R.id.textView);
 }
}
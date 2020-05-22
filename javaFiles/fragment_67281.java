public class A extends Activity {

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
   Button.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
             startActivity(new Intent(A.this, B.class));
             finish(); // you must write this also in A activity to close whole application
        }
    });
 }

    public class B extends Activity {

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_1);
   Button.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
             finish();
        }
    });
 }
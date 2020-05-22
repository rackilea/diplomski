public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    String baseUrl = "https://tpdevproject.firebaseio.com/";
    final DatabaseReference fb = FirebaseDatabase.getInstance().getReference("comments");
    final EditText et = (EditText) findViewById(R.id.comment);
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Button btn = (Button) findViewById(R.id.send);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(user != null)
                    fb.push().child("comment").setValue(et.getText().toString());
            }
        });
    }

}
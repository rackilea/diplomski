public class MainActivity extends AppCompatActivity {

    boolean resumestate = false;
    LinearLayout ll; //The main layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.mainactivity_ll);

    }

    // Invoke the pop activity, setting resumestate to indicate this      
    public void doTestButton(View v) {
        Toast.makeText(this,"You Clicked the Test Button",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Pop.class);
        startActivity(intent);
        resumestate = true;
    }

    //Check if the activity was invoked and if so set background colour
    @Override
    protected void onResume() {
        super.onResume();
        if (resumestate) {
            ll.setBackgroundColor(Color.argb(250,0,0,0));
            resumestate = false;
        }
    }
}
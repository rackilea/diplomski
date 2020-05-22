public class MainActivity extends AppCompatActivity {

    boolean resumestate = false;
    LinearLayout ll;
    int requestcode = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.mainactivity_ll);

    }

    public void doTestButton(View v) {
        Toast.makeText(this,"You Clicked the Test Button",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Pop.class);
        startActivityForResult(intent,requestcode);
        resumestate = true;
    }

    @Override
    protected void onActivityResult(int rqstcode, int resultcode, Intent data) {
        if (rqstcode == requestcode) {
            if (resultcode == Activity.RESULT_OK) {
                int newcolour = data.getIntExtra("BGRNDCOLOUR",Color.argb(250,48,48,48));
                ll.setBackgroundColor(newcolour);
            }
        }
    }
}
public class MainActivity extends AppCompatActivity { 
TextView showValue;
TextView showTimeValue;
int counter = 0;
//Declare here the simpleChonometer object
Chronometer simpleChronometer;

@Override 
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
//Initiate here the simpleChronometer object
simpleChronometer =  (Chronometer) findViewById(R.id.TimeValue); // initiate a chronometer

Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(toolbar);

FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
fab.setOnClickListener(new View.OnClickListener() {
    @Override 
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show(); 
    } 
}); 

showValue = (TextView) findViewById(R.id.CountValue);
showTimeValue = (TextView) findViewById(R.id.TimeValue);
}
...
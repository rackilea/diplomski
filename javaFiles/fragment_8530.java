public class Demo4 extends AppCompatActivity {

private Button b;
private final String CALL_DEFAULT_MAP = "call_default_map";


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_daily__schedule);


    if(getIntent() != null) {//1
        if(getIntent().getStringExtra(CALL_DEFAULT_MAP) != null) {
            if (getIntent().getStringExtra(CALL_DEFAULT_MAP).equals("true")) {
                defaultMap();
            }
        }
    }


    b = (Button) findViewById(R.id.b);
    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent myIntent = new Intent(Demo4.this, Demo5.class);
            finish();
            startActivity(myIntent);

        }
    });

}

public void defaultMap() {
            Toast.makeText(getApplicationContext(),"defaultMap()---called",Toast.LENGTH_LONG).show();
}


}
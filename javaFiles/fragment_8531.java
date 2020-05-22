public class Demo5 extends AppCompatActivity {

private Button home;
private final String CALL_DEFAULT_MAP = "call_default_map";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_in_route_display);


    home = (Button) findViewById(R.id.home);

    home.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Intent myIntent = new Intent(Demo5.this, Demo4.class);
            myIntent.putExtra(CALL_DEFAULT_MAP,"true");//1
            finish();
            startActivity(myIntent);

        }
    });

}


}
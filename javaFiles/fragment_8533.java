public class Demo5 extends AppCompatActivity {

private Button home;
private final String CALL_DEFAULT_MAP = "call_default_map";
private SharedPreferences p;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_in_route_display);

    p = getApplicationContext().getSharedPreferences("p_key",
            0);

    home = (Button) findViewById(R.id.home);

    home.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            setBoolean(CALL_DEFAULT_MAP , true);//2
            Intent myIntent = new Intent(Demo5.this, Demo4.class);
                            finish();
            startActivity(myIntent);

        }
    });

}

public void setBoolean(String Name, boolean value)
{
    if(p != null){
    SharedPreferences.Editor editor = p.edit();
    editor.putBoolean(Name, value);
    editor.apply();
    }
}

}
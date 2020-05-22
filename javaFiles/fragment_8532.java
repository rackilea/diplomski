public class Demo4 extends AppCompatActivity {

private Button b;
private final String CALL_DEFAULT_MAP = "call_default_map";
private SharedPreferences p;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_daily__schedule);

    p = getApplicationContext().getSharedPreferences("p_key",
            0);//2


    if(p != null){//2
        if(p.getBoolean(CALL_DEFAULT_MAP , false)){
            defaultMap();
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
    setBoolean(CALL_DEFAULT_MAP , false);//2
    Toast.makeText(getApplicationContext(),"defaultMap()---called",Toast.LENGTH_LONG).show();
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
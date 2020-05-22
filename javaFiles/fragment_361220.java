public class MainActivity extends Activity {

    int counter;
    Button add;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.button1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCounter(counter + 1);
            }
        });
        display = (TextView) findViewById(R.id.textView1);
        loadCounter(); // must come after display is assigned
    }

    private void loadCounter(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        setCounter(sp.getInt("click", 0));
    }

    private void setCounter(int value) {
        counter = value;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Editor edit = sp.edit();
        edit.put("click", counter);
        edit.apply(); // apply() is better than commit()
        display.setText("You Have " +
            (counter > 0 ? String.valueOf(counter) : "zero");
    }
}
public class Main2Activity extends AppCompatActivity {

Switch aSwitch;
Button back;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    aSwitch = (Switch) findViewById(R.id.switch1);
    SharedPreferences sharedPreference = getSharedPreferences("switch", MODE_PRIVATE);
    boolean isChecked = sharedPreference.getBoolean("status",false);
    Log.d("Shriyansh",isChecked+"");
    aSwitch.setChecked(isChecked);
    aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // do something, the isChecked will be
            // true if the switch is in the On position
            SharedPreferences.Editor editor = getSharedPreferences("switch", MODE_PRIVATE).edit();
            editor.putBoolean("status", isChecked);
            editor.commit();
            Log.d("Shriyansh1",isChecked+"");
        }
    });

    back = (Button) findViewById(R.id.btnBack);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent swIntent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(swIntent);
        }
    });

}
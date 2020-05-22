public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new Work()).commit();
    }

    public void onTimeSet(TimePicker timePicker, int i, int i1){
        String tag = (String)timePicker.getTag();
        switch(tag){
            case TIME_PICKER:
                TextView textView = (TextView)findViewById(R.id.textstart);
                textView.setText("Start Hour: "+ i + " Minutes: "+ i1);
                break;
            case TIME_PICKER_2:
                TextView textView2 = (TextView)findViewById(R.id.textend);
                textView2.setText("Start Hour: "+ i + " Minutes: "+ i1);
                break;
        }
    }
}
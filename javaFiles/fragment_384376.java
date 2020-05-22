public class MainActivity extends AppCompatActivity {
    TextView autoTextIncreament;
    String stringValue="ABB";
    long intValue=20180001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoTextIncreament = findViewById(R.id.txt_autoincreament);
    }

    public void Click(View view){
        autoTextIncreament.setText(getValue());
    }

    private String getValue() {
        return stringValue+String.valueOf(intValue++);
    }
}
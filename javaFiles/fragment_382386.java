public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.YOUR_BUTTON);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letsee();
            }
        });
    }

    public void letsee() {
        setContentView(R.layout.test);

        TextView tv = (TextView) findViewById(R.id.testview);
        tv.setText("DOES THIS EVEN WORK?");
    }
}
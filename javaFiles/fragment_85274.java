public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.outputText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, SecondActivity.class); // Explicit intent
                Intent intent = new Intent(); // Implicit intent
                intent.setAction("tj.xona.customaction"); // custom action
                startActivityForResult(intent, SecondActivity.CUSTOM_INTENT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SecondActivity.CUSTOM_INTENT && resultCode == RESULT_OK) {
            String msg = data.getStringExtra(SecondActivity.MESSAGE_BACK);
            textView.setText(msg);
        }
    }
}
public class SecondActivity extends AppCompatActivity {

    public static final int CUSTOM_INTENT = 1;
    public static final String MESSAGE_BACK = "message";

    private EditText edit;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edit = (EditText) findViewById(R.id.edit);
        send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = edit.getText().toString();

                Intent intent = new Intent();
                intent.putExtra(MESSAGE_BACK, msg);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
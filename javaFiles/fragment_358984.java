public class MainActivity extends AppCompatActivity {

    private String right;
    private String wrong;
    private String translation1;
    private EditText input1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.right = getString(R.string.right);
        this.wrong = getString(R.string.wrong);
        this.translation1 = getString(R.string.translation1);
        this.input1 = (EditText) findViewById(R.id.input1);
    }

    public void Check(View view) {
        String string1 = input1.getText().toString();

        if (string1.equals(translation1)) {
            input1.setText(right);
        }
        else {
            input1.setText(wrong);
        }
    }
}
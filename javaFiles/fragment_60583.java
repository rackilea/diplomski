...

public class MainActivity extends Activity {

public static final String MIME_TEXT_PLAIN = "text/plain";
public static final String TAG = "NfcDemo";

private TextView mTextView;
private NfcAdapter mNfcAdapter;
private EditText mEditText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTextView = (TextView) findViewById(R.id.textView_explanation);
    mEditText = (EditText) findViewById(R.id.editText1);

    //Set Text View value in Edit Text
    mEditText.setText(mTextView.getText().toString());

    ...
}


...
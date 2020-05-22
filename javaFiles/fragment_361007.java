public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        editText = (EditText) findViewById(R.id.numToSend);
        editText.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_NULL
                && event.getAction() == KeyEvent.ACTION_DOWN) {

            //both attempt are the same
            Log.d("onEditorAction", view.getText().toString());
            Log.d("onEditorAction", editText.getText().toString());
        }
        return true;
    }
}
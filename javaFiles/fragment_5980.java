public class TestingForSO extends ActionBarActivity {
    private static final String ENAME = "ENAME";
    EditText etename;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_for_so);
        if (savedInstanceState != null) {
            name = savedInstanceState.getString(ENAME, "");
            Log.e("NAME", "saved");
        } else{
            Log.e("NAME", "not_saved");
        }
        etename = (EditText) findViewById(R.id.etename);
        etename.setText(name);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.e("NAME", "Saving");
        savedInstanceState.putString(ENAME, etename.getText().toString());
    }
}
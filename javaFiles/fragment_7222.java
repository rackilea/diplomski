private final EditText milkdone;
private final EditText brixdone;
private double milkdone2;
private double brixdone2;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

milkdone = (EditText) findViewById(R.id.milkliter);
brixdone = (EditText) findViewById(R.id.brix);

milkdone.setOnEditorActionListener(new OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean handled = false;
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            milkdone2 = Double.parseDouble(milkdone.getText().toString());
            brixdone2 = Double.parseDouble(brixdone.getText().toString());
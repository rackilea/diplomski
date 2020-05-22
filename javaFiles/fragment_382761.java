TextView txtTest = null;
    CheckBox chkTest = null;
    Button btnTest = null;
    EditText etTest = null;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtTest = (TextView) findViewById(R.id.txtOut);
    chkTest = (CheckBox) findViewById(R.id.chkTest);
    btnTest = (Button) findViewById(R.id.btnTest);
    etTest = (EditText) findViewById(R.id.etTest);

    ....
 }


 void reset(String text) {
      chkTest.setChecked(false);
      txtTest.setText(text);
 }
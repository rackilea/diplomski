float txt1 = 0, txt2 = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    EditText txtbx1 = (EditText) findViewById(R.id.txtbx1);
    EditText txtbx2 = (EditText) findViewById(R.id.txtbx2);
    final EditText txtbx3 = (EditText) findViewById(R.id.txtbx3);
    TextView txtvw1 = (TextView) findViewById(R.id.txtvw1);
    TextView txtvw2 = (TextView) findViewById(R.id.txtvw2);
    TextView txtvw3 = (TextView) findViewById(R.id.txtvw3);


    txtbx1.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() != 0)
                txt1 = Float.parseFloat(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            changeValue(txt1, txt2, txtbx3);
        }
    });

    txtbx2.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() != 0)
                txt2 = Float.parseFloat(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            changeValue(txt1, txt2, txtbx3);
        }
    });


}

private void changeValue(float txt1, float txt2, EditText txtbx3) {
    float Percent = (txt2 * txt1) / 100;
    txtbx3.setText(String.valueOf(Percent));
}
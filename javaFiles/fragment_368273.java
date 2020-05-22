public class Main2Activity extends AppCompatActivity {

Spinner sp1;

ArrayAdapter<String> sAdapter1;
ArrayAdapter<String> sAdapter2;
String s1[] = {"Permanent"};
String s2[] = {"Permanent", "Temporary"};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    sp1 = (Spinner) findViewById(R.id.spinner1);
    EditText et = (EditText) findViewById(R.id.editText1);

    sAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s1);
    sAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    sAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s2);
    sAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    et.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.toString().equals("Brand")) {
                sp1.setAdapter(sAdapter1);
            } else {
                sp1.setAdapter(sAdapter2);
            }
        }
    });

}
}
public TextWatcher last;
    public TextWatcher _list1;
    public TextWatcher _list2;

    public EditText active;
    public RadioButton checked;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText t1 = (EditText) findViewById(R.id.text1);
        final EditText t2 = (EditText) findViewById(R.id.text2);
        final EditText t3 = (EditText) findViewById(R.id.text3);
        final EditText t4 = (EditText) findViewById(R.id.text4);
        final Context c = getApplicationContext();

        final RadioGroup g1 = (RadioGroup) findViewById(R.id.radioGroup1);
        g1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checked = (RadioButton) g1.findViewById(g1.getCheckedRadioButtonId());

                if (((String) checked.getText()).equalsIgnoreCase("But1")) {
                    active.removeTextChangedListener(last);
                    active = t1;
                    active.setText("");
                    active.addTextChangedListener(_list1);
                    last = _list1;
                } else if (((String) checked.getText()).equalsIgnoreCase("But2")) {
                    active.removeTextChangedListener(last);
                    active = t2;
                    active.setText("");
                    active.addTextChangedListener(_list2);
                    last = _list2;
                } else if (((String) checked.getText()).equalsIgnoreCase("But3")) {
                    active = t3;
                } else if (((String) checked.getText()).equalsIgnoreCase("But4")) {
                    active = t4;
                }
            }
        });

        checked = (RadioButton) g1.findViewById(g1.getCheckedRadioButtonId());

        active = t1;
        active.setText("");
        _list1 = (new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(c, "onTextChanged called(_list1 watcher)", Toast.LENGTH_SHORT).show();
            }
        });
        _list2 = (new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(c, "onTextChanged called(_list2 watcher)", Toast.LENGTH_SHORT).show();
            }
        });
        active.addTextChangedListener(_list1);
        last = _list1;
    }

}
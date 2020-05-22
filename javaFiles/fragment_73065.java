@Override

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.newtimer);
    Spinner spColor1 = (Spinner)findViewById(R.id.spColor1);
    spColor1.setAdapter(new MyAdapter(NewTimer.this, R.layout.row, strings));
    spColor1.setOnItemSelectedListener(this);
    Spinner spColor2 = (Spinner)findViewById(R.id.spColor2);
    spColor2.setAdapter(new MyAdapter(NewTimer.this, R.layout.row, strings));
    spColor2.setOnItemSelectedListener(this);
    etTime = (EditText) findViewById(R.id.etTime);
    btnOkay = (Button) findViewById(R.id.btnOkay);
    btnOkay.setOnClickListener(this);

    Spinner spMode = (Spinner) findViewById(R.id.spMode);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, 
                                                                         R.array.spMode_items, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spMode.setAdapter(adapter);
    spMode.setOnItemSelectedListener(this); }

public void onItemSelected(AdapterView<?> parent,
                           View v, int pos, long id) {
    switch (parent.getId())
    {
        case R.id.spMode:
            mode = pos;
            break;

        case R.id.spColor1:
            color1 = pos;
            break;

        case R.id.spColor2:
            color2 = pos;
            break;
    } }
Button save;
TextView currentAddress;
EditText addressNew;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_location_select_from_alert_buttons);

    save = (Button)findViewById(R.id.saveBtn);
    currentAddress = (TextView)findViewById(R.id.CurrAddress);
    addressNew = (EditText)findViewById(R.id.tbNewAddress);

    openDB();

}
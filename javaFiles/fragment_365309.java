Button buttonEntry;
Button buttonMail;
Button buttonSettings;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buttonEntry = (Button)findViewById(R.id.action_add_entry);
  buttonEntry.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
             Intent entry = new Intent(MainActivity.this, AddEntry.class);
             startActivity(entry);
          setContentView(R.layout.newentry);
      }
  });
    buttonMail = (Button)findViewById(R.id.action_add_email);
    buttonMail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
               Intent mail = new Intent(MainActivity.this, AddMail.class);
               startActivity(mail);
            setContentView(R.layout.newmail);

        }
    });
    buttonSettings = (Button)findViewById(R.id.action_settings);
    buttonSettings.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
               Intent settings = new Intent(MainActivity.this, AppSettings.class);
                startActivity(settings);
            setContentView(R.layout.settings);
        }
    });
}
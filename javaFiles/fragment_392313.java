protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MainActivity.context = getApplicationContext();
    setContentView(R.layout.activity_main);
    Field[] fields = R.raw.class.getFields();
    String[] names = new String[fields.length];

    // Step 1: Read the names
    for (int i = 0; i < fields.length; i++) {
        names[i] = fields[i].getName();
    }
    // Step 2: Read as InputStream
    for (int i = 0  ; i < allStringsNames.length ; i++){
        int id = getResources().getIdentifier(names[i] , "raw", getPackageName());
        InputStream inputStream = getResources().openRawResource(id);
        //Do your stuff with variable inputStream
    }
    }
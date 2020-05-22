@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        final Editor editor = pref.edit();


         x = pref.getInt("Value", 0);  //assign values to global variable
         //rest of the code
    }
@Override 
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.dialog_main); 

    TextView user = (TextView) findViewById(R.id.tvUser); 
    TextView store = (TextView) findViewById(R.id.tvStore);

    Intent intent = getIntent();
    if(intent != null){ //I always check this to avoid Exceptions
      String pullerName = intent.getStringExtra("puller-name");
      String storeName = intent.getStringExtra("store-name");

      if(pullerName != null) user.setText(pullerName);

      if(storeName != null) store.setText(storeName);
    }
}
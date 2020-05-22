@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (savedInstanceState == null) {        
         getSupportFragmentManager()
             .beginTransaction()
             .add(R.id.frg, FragJos.newInstance())
             .commit(); 
    }
}
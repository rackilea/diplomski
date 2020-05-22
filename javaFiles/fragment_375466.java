@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    Intent intent = getIntent();
    if(intent!=null){
        nome = intent.getStringExtra("nome");
        email = intent.getStringExtra("email");
        uid= intent.getStringExtra("uid");
        UominiEDonne mainFragment = UominiEDonne.newInstance(uid);
        FragmentTransaction fragmentTransaction =
        getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, mainFragment);
        fragmentTransaction.commit();
    }
}
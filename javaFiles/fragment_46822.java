List<Selfie> selfies;
private CustomAdapter ADAPTER;
ListView lv;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    lv = (ListView) findViewById(R.id.listView);
    selfies = new ArrayList<Selfie>();
    ADAPTER = new CustomAdapter(this, selfies);

    lv.setAdapter(ADAPTER);
}

@Override
protected void onResume() {
    super.onResume();
    /*
    *I don't quite see the purpose in this below section, 
    *as you can account for a null ArrayList in your adapter class
    */
    if (ADAPTER.getCount() >= 0) {
    lv.setAdapter(ADAPTER);
    }

}
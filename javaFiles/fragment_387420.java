@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.main);

        ListView lv = (ListView)findViewById(R.id.accountList);
        lv.setAdapter(new ArrayAdapter<String>(this, R.id.accountList, TEXTS));


    }
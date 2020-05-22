@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //...
    listView.setOnItemClickListener(new MyClickListener(datas));

    //...
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_stores); not required
    ButterKnife.bind(this); 

    loadRecyclerView();
    testData();

}

@Override
protected int getLayoutResourceId() {
    return R.layout.activity_stores;
}
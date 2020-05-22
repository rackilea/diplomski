@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_supplication_detail);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    chapter = getIntent().getIntExtra(Constants.SELECTED_ITEM, 1);

    fragmentSupplicationDetail = new FragmentSupplicationDetail();
    Bundle extras = new Bundle();
    extras.putInt(Constants.SELECTED_ITEM, chapter);
    fragmentSupplicationDetail.setArguments(extras);
    transaction.replace(R.id.container, fragmentSupplicationDetail, SUPPLICATION_FRAGMENT_TAG).commit();
}
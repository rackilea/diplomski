@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_supplication_detail);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    chapter = getIntent().getIntExtra(Constants.SELECTED_ITEM, 1);
    if (getSupportFragmentManager().findFragmentByTag(SUPPLICATION_FRAGMENT_TAG) == null){
        fragmentSupplicationDetail = new FragmentSupplicationDetail();
        Bundle extras = new Bundle();
        extras.putInt(Constants.SELECTED_ITEM, chapter);
        fragmentSupplicationDetail.setArguments(extras);
        Log.d(Constants.LOG_TAG, getClass().getSimpleName() + ": Создаем фрагмент ");
    }else {
        fragmentSupplicationDetail = (FragmentSupplicationDetail) getSupportFragmentManager().findFragmentByTag(SUPPLICATION_FRAGMENT_TAG);
        Log.d(Constants.LOG_TAG, getClass().getSimpleName() + ": Восстанавливаем фрагмент ");
    }
    transaction.replace(R.id.container, fragmentSupplicationDetail, SUPPLICATION_FRAGMENT_TAG).commit();
}
private Realm realm;    

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...
    realm = Realm.getDefaultInstance(); //<--- this is on ui thread
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);

    // processing intent data
    if (getIntent()!=null) {
        Bundle bundle = getIntent().getExtras();
        if (bundle.containsKey("KEY_OF_EXTRA")) {
            ArrayList<MyParcelableList> listOfList = bundle.getParcelableArrayList("KEY_OF_EXTRA");
            if (listOfList != null)
                // Do something here ...
                for (MyParcelableList list : listOfList) {
                    for (MyParcelable p : list) {
                        Log.v("TargetActivity", "p.data=" + p.data);
                    }
                }
        }
    }
}
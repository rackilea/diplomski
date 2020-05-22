private RealmChangeListener realmChangeListener;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.realm = RealmController.with(this).getRealm();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        setupRecycler();

        realmChangeListener = new RealmChangeListener() {
            @Override
            public void onChange(Object element) {
                RealmController.with(MainActivity.this).refresh();
            }
        };
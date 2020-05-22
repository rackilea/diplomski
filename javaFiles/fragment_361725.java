@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        ButterKnife.bind(this); 
        setSupportActionBar(toolbar);
        navManagement();

    }
    protected abstract int getLayoutResourceId();
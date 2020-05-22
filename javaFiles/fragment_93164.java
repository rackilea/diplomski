@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_pref);

    getFragmentManager().beginTransaction().replace(R.id.rep, new 
    PrefFrag()).commit();
    }
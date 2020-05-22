private Database myDBAdapter;

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDBAdapter = new Database(this).open();
        myDBAdapter.close();
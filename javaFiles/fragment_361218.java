Thread threadMenu;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        threadMenu = new Thread(runnable);
        threadMenu.start();

    }
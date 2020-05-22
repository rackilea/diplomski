@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = (ImageView) findViewById(R.id.myImageView);
        new ImageDownloader(iv).execute("http://wanderingoak.net/bridge.png");
    }
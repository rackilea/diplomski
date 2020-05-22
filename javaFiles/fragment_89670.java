private Spinner spin;
    private YouTubePlayerView ytpv;
    private YouTubePlayer ytp;

    /*START: Standard Activity Functions*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = (Spinner) findViewById(R.id.spinner1);//// code added
        addListenerOnSpinnerItemSelection();//setup listener on spinner
        addListenerOnButton();//setup listener on button

        ytpv = (YouTubePlayerView) findViewById(R.id.youtubeplayer);
        ytpv.initialize("My API KEY", this);
    }
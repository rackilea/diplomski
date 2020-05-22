@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loaderManager=getLoaderManager();
        textView=findViewById(R.id.tv_result);
        if (loaderManager.getLoader(0) ==null){
            loaderManager.initLoader(0,null,this).forceLoad();;

        }
    }
@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        feedView = ((ListView)findViewById(R.id.listFeed));
        new BgTask().execute(); 

        feedView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) { 

                Feed feed = (Feed) feedView.getItemAtPosition(position);
                Log.d("Date", ""+getDatePreferedFormat(feed.getPubDate()));
            }
        });

        feedView.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {  
                shareIt(position);
                return true;
            }
        });
    }
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (initChatBarUI()){
            mSendImageButton.setOnClickListener(MainActivity.this);
            mEmoImageButton.setOnClickListener(MainActivity.this);
        }

        mMessageList = new CopyOnWriteArrayList<>();

        final LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mChatMessagesRecyclerView = (RecyclerView) findViewById(R.id.chat_msg_rv);
        mChatMessagesRecyclerView.setLayoutManager(layoutManager);
        mChatMessageAdapter = new ChatMessageAdapter(MainActivity.this, mMessageList);
        mChatMessagesRecyclerView.setAdapter(mChatMessageAdapter);

        mChatMessagesRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                final int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                final int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                mChatMessageAdapter.showAndHideDate(mChatMessagesRecyclerView, firstVisibleItemPosition, lastVisibleItemPosition); // Here I'm calling the method defined in Adapter class
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });   
    }
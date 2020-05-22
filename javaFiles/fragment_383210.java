protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);
        mRecyclerView = findViewById(R.id.recyclerViewNearby);

        // you passed mNearbyAdapter here
        mRecyclerView.setAdapter(mNearbyAdapter);  

        // but you created the object for it here
        mNearbyAdapter = new NearbyAdapter(NearbyActivity.this, mNearbyList);
        ...
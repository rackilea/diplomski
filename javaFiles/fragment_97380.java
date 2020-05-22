@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
    swipeLayout.setOnRefreshListener(this);
    swipeLayout.setColorScheme(android.R.color.holo_blue_bright, 
            android.R.color.holo_green_light, 
            android.R.color.holo_orange_light, 
            android.R.color.holo_red_light);
}


@Override public void onRefresh() {
    new Handler().postDelayed(new Runnable() {
        @Override public void run() {
            swipeLayout.setRefreshing(false);
        }
    }, 5000);
}
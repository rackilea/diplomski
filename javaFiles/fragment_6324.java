//fields
private ArrayList<Video> videos;
private ArrayAdapter mAdapter;
private View footer;

protected void onCreate(Bundle savedInstanceState) {
    ListView list = findViewById(R.id.list);
    footer = getLayoutInflater().inflate(R.layout.more_results, null);
    list.addFooterView(footer);
    videos = new ArrayList<Video>
    mAdapter = new VideosAdapter(this, videos);
    list.setAdapter(mAdapter);
}

public addItemsToList(List<Video> items){
    videos.addAll(items);
    mAdapter.notifyDataSetChanged();
}
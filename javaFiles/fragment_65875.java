public class VideoListActivity extends ListActivity{

    static List<VideoItem> videoFileList;
    static Context context;
    public class VideoAapter extends ArrayAdapter{
    //.....................
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Search search= new Search();
        search.execute(new String[]{});


    }
    public void updateAdapter(ArrayList<String> list) {
        setListAdapter(new VideoAapter(VideoListActivity.this,R.layout.list_item_video, videoFileList));
     }
}
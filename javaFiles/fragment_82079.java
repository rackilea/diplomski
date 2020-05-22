public class ViewFeeds extends Activity {
    private ArrayList<String> items = new ArrayList<String>();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewfeeds);

        lv = (ListView) findViewById(R.id.listView1);

        ...
    }

    ...
}
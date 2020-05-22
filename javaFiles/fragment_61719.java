public class MainActivity extends Activity
{
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listView = (ListView) findViewById(R.id.listview);
        list = new ArrayList();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        new LoadImages(list, adapter).execute();
    }
}
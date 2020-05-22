public class MyActivity extends Activity implements AdapterView.OnItemClickListener {

    private ArrayAdapter<Item> mAdapter;

    private static enum Item {Create,Edit,Settings,About}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //-- can set up from external layout also--
        ListView list = new ListView(this);
        setContentView(list);

        list.setOnItemClickListener(this);

        mAdapter = new ArrayAdapter<Item>(this,android.R.layout.simple_list_item_1,Item.values());
        list.setAdapter(mAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (mAdapter.getItem(i)){
            case Create:
                //--do stuff--
                break;
            case Edit:
                //--do stuff--
                break;
            case Settings:
                //--do stuff--
                break;
            case About:
                //--do stuff--
                break;
        }
    }
}
public class MainActivity extends AppCompatActivity {

    DataBaseHelper mDataBaseHelper;
    ArrayList<String> data;
    ListView list;
    ArrayAdapter<String> listadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addSomeTestData();
        populateLisView();
    }

    private void example001() {
    }

    public void populateLisView() {
        mDataBaseHelper = new DataBaseHelper(this);
        list = (ListView) this.findViewById(R.id.myListId);
        data = mDataBaseHelper.getData();
        if (listadapter == null) {
            listadapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,data);
            list.setAdapter(listadapter);
            list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    //mDataBaseHelper.deleteTaskWrong(data.get(position)); // ooops
                    mDataBaseHelper.deleteTaskByCol2(data.get(position));
                    populateLisView();
                    return true;
                }
            });
        } else {
            listadapter.clear();
            listadapter.addAll(data);
            listadapter.notifyDataSetChanged();
        }
    }

    private void addSomeTestData() {
        if (mDataBaseHelper == null) {
            mDataBaseHelper = new DataBaseHelper(this);
        }
        if (DatabaseUtils.queryNumEntries(mDataBaseHelper.getWritableDatabase(),DataBaseHelper.TABLE_NAME) > 0) return;
        mDataBaseHelper.addMytableRow("Test1","Test1");
        mDataBaseHelper.addMytableRow("Test2","Test2");
        mDataBaseHelper.addMytableRow("Test3","Test3");
        mDataBaseHelper.addMytableRow("Test4","Test4");
    }
}
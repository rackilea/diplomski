public class DisplayActivity extends Activity {

    ListView lv;
    ArrayList<String> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        MyApplication mapp=MyApplication.getInstance();
        myList = mapp.getArrayListMapData();

        lv = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(DisplayActivity.this,android.R.layout.simple_expandable_list_item_1, myList);

        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display, menu);
        return true;
    }

}
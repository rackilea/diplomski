public class SimpleListItem1Activity extends Activity {
 String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
      "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
      "Linux", "OS/2" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list_item1);
        ListView listView = (ListView) findViewById(R.id.mylist);  

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, values);
             listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.simple_list_item1, menu);
        return true; 
 }

}
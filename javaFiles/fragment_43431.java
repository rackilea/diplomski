public class MainActivity extends Activity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate ( savedInstanceState ); 
    setContentView(R.layout.my_layout);
    ListView listView = (ListView) findViewById(R.id.my_list_view);
    ArrayList<Map<String, String>> list = buildData();
    String[] from = { "article", "description" };
    int[] to = { android.R.id.text1, android.R.id.text2 };
    SimpleAdapter adapter = new SimpleAdapter(this, list,
    android.R.layout.simple_list_item_2, from, to);
    listView.setAdapter(adapter);            
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent1 = new Intent(MainActivity.this, DisplayMainActivity.class);
            MainActivity.this.startActivity(intent1);
        }
    });
}
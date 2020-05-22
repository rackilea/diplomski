public class MainActivity extends AppCompatActivity {

     List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("Android");
        list.add("iPhone");
        list.add("Windows");
        list.add("Blackberry");
        list.add("Mac");
        list.add("Laptop");
        list.add("LCD");
        list.add("Dell");

        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.list_view_item, list);
        ListView listView = (ListView) findViewById(R.id.mobile_list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked: " + list.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setAdapter(adapter);
    }
}
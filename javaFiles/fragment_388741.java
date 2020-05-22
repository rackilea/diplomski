public class MainActivity extends Activity {
private ListView list;
private LazyAdapter adapter;
private String res = "";
//here declare as class variable....
private String[] imageUrls;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //here initialize it....
    imageUrls = new String[1];

    Button btn1=(Button)findViewById(R.id.button1);
    list = (ListView) findViewById(R.id.listView1);
    adapter = new LazyAdapter(this, imageUrls);
    list.setAdapter(adapter);

    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new server_side("http://192.168.1.6:81/upload/time.php","").execute();
            //here asign it some value....
            imageUrls[0] = {"http://localhost:81/upload/url.jpg"};
            if (!res.equals("")) {
                Toast.makeText(getApplicationContext(), "get data", Toast.LENGTH_SHORT).show();
            }
        }
    });
}
}
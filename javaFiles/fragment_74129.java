public class Namelist extends AppCompatActivity {

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};
    ListView l1;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namelist);

        l1 = findViewById(R.id.list);

        arrayAdapter = new ArrayAdapter<String>(Namelist.this,android.R.layout.simple_list_item_1,mobileArray);
       l1.setAdapter(arrayAdapter);
    }
}
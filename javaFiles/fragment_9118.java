public class PairedDevices extends Activity 
{
    ListView listViewPaired;
    ArrayList<String> pairedDevices = null; 
    ArrayAdapter<String> listAdapter;

    public void onCreate(Bundle savedInstanceState) 
    {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_paired_devices);
         listViewPaired = (ListView)findViewById(R.id.listViewPaired);
         pairedDevices = (ArrayList<String>)getIntent().getSerializableExtra("arrayListPaired");
         listAdapter = new ArrayAdapter<String>(PairedDevices.this, android.R.layout.simple_list_item_1, pairedDevices);
         listViewPaired.setAdapter(listAdapter);
    }
}
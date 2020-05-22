public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nama [] = {"Olala","bolabola","yolooo","fighter"};

        ListView listView = (ListView)findViewById(R.id.ListView);
        CostumAdapter costumAdapter = new CostumAdapter(nama);
        listView.setAdapter(costumAdapter);

}

public class CostumAdapter extends BaseAdapter{

    String[] nama;

    public CostumAdapter(String[] nama){
        this.nama = nama;
    }

    @Override
    public int getCount() {
        return nama.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = getLayoutInflater().inflate(R.layout.arablayout,null);

        TextView textViewName = (TextView)convertView.findViewById(R.id.textview);

        textViewName.setText(nama[position]);



        return convertView;
    }

}
}
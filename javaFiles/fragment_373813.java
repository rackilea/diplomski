public class MainActivity extends AppCompatActivity {

    RecyclerView mList;
    RecyclerView.LayoutManager mLayoutManager;
    MyAdapter mMyAdapter;

    // The underlying data (just a list of strings for the macs)
    ArrayList<String> mymacliist = new ArrayList<>(Arrays.asList("M1","M2","M3"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = this.findViewById(R.id.mylist);
        mLayoutManager = new LinearLayoutManager(this);
        mList.setLayoutManager(mLayoutManager);
        mMyAdapter = new MyAdapter(this,mymacliist);
        mList.setAdapter(mMyAdapter);
    }
}
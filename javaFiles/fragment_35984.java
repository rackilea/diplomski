public class MainActivity extends AppCompatActivity implements ListListener{

    AAdapter adapter;
    ListView lv;
    List<Route> myNames;
    ListListener listListener=MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listnames);


        myNames=new ArrayList<>();

        /* DEMO DATA U NEED TO FETCH YOUR DATA */
        myNames.add(new Route("FIRST",false));
        myNames.add(new Route("Second",false));
        myNames.add(new Route("Third",false));
        myNames.add(new Route("Fourth",false));
        myNames.add(new Route("Fifth",false));

        myNames.add(new Route("FIRST",false));
        myNames.add(new Route("Second",false));
        myNames.add(new Route("Third",false));
        myNames.add(new Route("Fourth",false));
        myNames.add(new Route("Fifth",false));

        myNames.add(new Route("FIRST",false));
        myNames.add(new Route("Second",false));
        myNames.add(new Route("Third",false));
        myNames.add(new Route("Fourth",false));
        myNames.add(new Route("Fifth",false));

        myNames.add(new Route("FIRST",false));
        myNames.add(new Route("Second",false));
        myNames.add(new Route("Third",false));
        myNames.add(new Route("Fourth",false));
        myNames.add(new Route("Fifth",false));


        adapter = new AAdapter(this, myNames,listListener);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void clickListItem(int position) {
        if(myNames.get(position).colorRed){
           myNames.get(position).colorRed=false;
        }else {
            myNames.get(position).colorRed=true;
        }
        adapter.notifyDataSetChanged();
    }
}
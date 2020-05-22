public class MainActivity extends AppCompatActivity {

    public ArrayList mainArr,arrOne, arrTwo;
    private MyAdapter myAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        myAdapter = new MyAdapter(this, configureList());
        listView.setAdapter(myAdapter);
    }

    public ArrayList configureList(){
        arrOne = new ArrayList();
        arrTwo = new ArrayList();
        mainArr = new ArrayList();
        arrOne.add(0, "Joe");
        arrOne.add(1, "Phil");
        arrOne.add(2, "Jose");
        arrTwo.add(0, "Mexico City");
        arrTwo.add(1, "Minneapolis");
        arrTwo.add(2, "Pittsburgh");

        for(int i = 0; i < arrOne.size(); i++){
            mainArr.add(i, arrOne.get(i) + " - " + arrTwo.get(i));
        }
        return  mainArr;
     }
}
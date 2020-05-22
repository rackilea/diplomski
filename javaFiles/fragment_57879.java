public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView g = (GridView) findViewById(R.id.grid_view);
        CustomAdapter adapter = new CustomAdapter(this, getData());
        g.setAdapter(adapter);
    }

    public ArrayList<Integer> getData(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.pic1);
        // add 2 - 11
        list.add(R.drawable.pic12);

        return list;
    }

}
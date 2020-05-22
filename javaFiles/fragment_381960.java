public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Menu Select Array
        String[] CoffeeShop = {"Creation","Starbucks","Caribou","Mo'Joe" };
        //Set list adapter for list
        setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_main,R.id.Coffee,CoffeeShop));
        //Create actions of list
    }

    protected void onListItemClick(ListView l, View v, int position, long id)
    {

    } 

}
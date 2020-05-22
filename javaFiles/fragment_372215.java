public class NEXT extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);
        boolean isAcceptors = getIntent().getBooleanExtra("acceptors", false);

        if (isAcceptors)   //did onClick="clicked"
        {
            setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, 
                getResources().getStringArray(R.array.acceptors)));
        }
        else
        {
            setListAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, 
                    getResources().getStringArray(R.array.donars)));
        }

   }
}
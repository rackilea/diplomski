public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public EditText search;
    //    private List<String> list = new ArrayList<String>();
    private List<DataHolder> list = new ArrayList<DataHolder>();
    SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = (EditText) findViewById(R.id.search);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        countryList();  // in this method, Create a list of items.

        // call the adapter with argument list of items and context.
        mAdapter = new SimpleAdapter(list, this);
        mRecyclerView.setAdapter(mAdapter);

        addTextListener();

    }

    // this method is used to create list of items.
    public void countryList() {

        DataHolder item = new DataHolder();
        item.setName("Afghanistan");
        item.setTranslation("demo trans1");

        list.add(item);

        DataHolder item1 = new DataHolder();
        item1.setName("Paksitan");
        item1.setTranslation("my pakistan");

        list.add(item1);
//        list.add("Afghanistan");
//        list.add("Albania");
//        list.add("Algeria");
//        list.add("Bangladesh");
//        list.add("Belarus");
//        list.add("Canada");
//        list.add("Cape Verde");
//        list.add("Central African Republic");
//        list.add("Denmark");
//        list.add("Dominican Republic");
//        list.add("Egypt");
//        list.add("France");
//        list.add("Germany");
//        list.add("Hong Kong");
//        list.add("India");
//        list.add("Iceland");

    }


    public void addTextListener() {

        search.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();

                final List<DataHolder> filteredList = new ArrayList<DataHolder>();

                for (int i = 0; i < list.size(); i++) {

                    final String text = list.get(i).getName().toLowerCase();
                    if (text.contains(query)) {

                        filteredList.add(list.get(i));
                    }
                }

                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mAdapter = new SimpleAdapter(filteredList, MainActivity.this);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();  // data set changed
            }
        });
    }
}

SimpleAdapter:

public class SimpleAdapter extends
        RecyclerView.Adapter<SimpleAdapter.MyViewHolder> {

    private List<DataHolder> list_item;
    public Context mcontext;


    public SimpleAdapter(List<DataHolder> list, Context context) {

        list_item = list;
        mcontext = context;
    }

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @Override
    public SimpleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a layout
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, null);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    // Called by RecyclerView to display the data at the specified position.
    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {


        viewHolder.country_name.setText(list_item.get(position).getName());
        viewHolder.country_translation.setText(list_item.get(position).getTranslation());

        viewHolder.country_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mcontext, list_item.get(position).getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    // initializes some private fields to be used by RecyclerView.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView country_name, country_translation;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            country_name = (TextView) itemLayoutView.findViewById(R.id.country_name);
            country_translation = (TextView) itemLayoutView.findViewById(R.id.country_translation);

        }
    }

    //Returns the total number of items in the data set hold by the adapter.
    @Override
    public int getItemCount() {
        return list_item.size();
    }

}
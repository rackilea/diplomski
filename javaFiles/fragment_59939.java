public class ExampleActivity extends AppCompatActivity {

    private ArrayAdapterSearchView searchView;
    private LinearLayout recycleLayout;
    private ArrayList<String> stringList;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private Toolbar mToolbar1, mToolbar2;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mToolbar1 = (Toolbar) findViewById(R.id.nested_toolbar_1);
        mToolbar2 = (Toolbar) findViewById(R.id.nested_toolbar_2);

        frameLayout = (FrameLayout) findViewById(R.id.nested_parentframe);

        setSupportActionBar(mToolbar2);
        getSupportActionBar().setTitle("Search");
        mToolbar1.setNavigationIcon(R.mipmap.ic_action_overflow);

        mToolbar2.setTitleTextColor(getResources().getColor(android.R.color.tertiary_text_light));

        recycleLayout = (LinearLayout) findViewById(R.id.recyclerViewLayout);

        recyclerView = (RecyclerView) findViewById(R.id.cardsList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String[] strArray = new String[]{"Item One", "Item Two", "Item Three", "Item Four", "Item Five"};
        //This is your String array
        for(int i = 0; i < strArray.length; i++){
            stringList.add(strArray[i]);
        }

        if(!stringList.isEmpty()){
            adapter = new CustomAdapter(this, stringList);
            recyclerView.setAdapter(adapter);

            recycleLayout.setVisibility(View.VISIBLE);

            adapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(String item) {
                    searchView.setQuery(item, false);
                }
            });
        }
        else{
            recycleLayout.setVisibility(View.GONE);
        }       

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_menu_item);

        searchView = (ArrayAdapterSearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setLayoutParams(new ActionBar.LayoutParams(Gravity.LEFT));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                if (query.length() != 0) {
                    if (null != adapter) {
                        adapter.filter(query.toString());//This will filter the RecyclerView
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    recyclerView.setVisibility(View.GONE);
                }
                return false;
            }
        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = searchView.getText();
                searchView.setSelection(length.length());
            }
        });

        return true;
    }

}
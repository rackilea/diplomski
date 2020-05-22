public class FragmentVictoriaLine extends Fragment {
    /**Declare other variables**/

    private MyAdapter myAdapter;

    public FragmentVictoriaLine() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_victoria_line, container, false);

        //Tell the system to call onCreateOptinsMenu
        setHasOptionsMenu(true);
        if (getActivity().findViewById(R.id.detail_container) != null) {
            mTwoPane = true;
        } else {
            mTwoPane = false;
        }

        mVictoria = new Victoria[]{
            new Victoria(R.string.bank, R.string.zone_1, WCBankActivity.class, FragmentWCBank.class),
            new Victoria(R.string.wat, R.string.zone_1, WCWATActivity.class, FragmentWCWAT.class)
        };

        //Declare your adapter here so you can access later
        myAdapter = new MyAdapter(getActivity(), mVictoria);

        final ListView listView = (ListView) v.findViewById(R.id.list_victoria);
        //Set teh adapter here.
        listView.setAdapter(myAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setTextFilterEnabled(true);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu items for use in the action bar
        inflater.inflate(R.menu.menu_victoria_line, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(false);

        SearchView.OnQueryTextListener textChangeListener = new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextChange(String newText)
            {
                // this is your adapter that will be filtered
                myAdapter.getFilter().filter(newText);
                System.out.println("on text chnge text: "+newText);
                return true;
            }
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                // this is your adapter that will be filtered
                myAdapter.getFilter().filter(query);
                System.out.println("on query submit: "+query);
                return true;
            }
        };
        searchView.setOnQueryTextListener(textChangeListener);

    }

   /**....rest of your code*/
}
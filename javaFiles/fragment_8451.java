public class FragmentHome2 extends FragmentBase {

    final List<Information> infoData = new ArrayList<>();

    public static FragmentHome2 getInstance() {
        // Required empty public constructor

            FragmentHome2 fragmentHome = new FragmentHome2();
            Bundle extraArguments = new Bundle();
            fragmentHome.setArguments(extraArguments);
            return fragmentHome;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv_home = (RecyclerView) inflater.inflate(R.layout.home_recyclerview, container, false);
        setupRecyclerView(rv_home);
        return rv_home;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_two, container, false);

        //Using the "View" to obtain the WebView
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        //initializing the Recycler View
        RecyclerView rvHome = (RecyclerView) view.findViewById(R.id.recyclerview_home);
        //pass the new initialized variable to the method for use
        setupRecyclerView(rvHome);

        //ParseQuery();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Timeline");
        query.setLimit(10);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(final List<ParseObject> objects, ParseException e) {

                if (e == null) {

                    for (int i = 0; i < objects.size(); i++) {

                        Information information = new Information();

                        information.setStatus(objects.get(i).getString("status"));
                        //information.setMainNewsStory(information.mNewsStory = objects.get(i).getString("shortinfo"));

                        infoData.add(information);
                    }//end for loop

                } else {
                    // something went wrong
                    //Toast.makeText(getApplicationContext(), "A problem occurred. Could not display news feed", Toast.LENGTH_LONG).show();

                }//End else

                //progress.dismiss();

                final HomeRecyclerViewAdapter mAdapter = new HomeRecyclerViewAdapter(getContext(), infoData);

                //initialize the recycler view
                RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerview_home);

                //use recycler view initialized variable to set adapter to current state
                rv.setAdapter(mAdapter);


                //notify data changes
                mAdapter.notifyDataSetChanged();


            }
        });


        return view;

    }

    //Set the recycler view adapter
    private void setupRecyclerView(final RecyclerView recyclerViewMain) {


        final LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerViewMain.getContext());
        recyclerViewMain.setLayoutManager(layoutManager);
        recyclerViewMain.setAdapter(new HomeRecyclerViewAdapter(getContext(),infoData ));
        recyclerViewMain.setHasFixedSize(true);

    }

}
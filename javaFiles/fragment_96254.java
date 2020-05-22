public class beste_zuiper extends android.support.v4.app.Fragment {
    private static final String TAG = "bestezuiperfragment";


    DatabaseHelper mDatabaseHelper;
    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.beste_zuiper_fragment, container, false);

        mListView = (ListView) view.findViewById(R.id.drinkers_lijst);

        mDatabaseHelper = new DatabaseHelper(getActivity());

        populateDrinkersLijst();

        return view;
    }

    public void populateDrinkersLijst() {

        Cursor data = mDatabaseHelper.getDrinkers();

        ArrayList<String> listData = new ArrayList<>();
        listData.add("test");

        // Check weather cursor is empty
        if(data.moveToFirst())
        {
            do
            {
                listData.add(data.getString(1));

            }while(data.moveToNext());
        }

        // Close cursor
        data.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }
}
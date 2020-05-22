public class StoreEntryFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    DBHelper mDBHlpr;
    Cursor mCsr;
    SimpleCursorAdapter mSCA;
    ListView mStoreList;

    public StoreEntryFragment() {
    }

    public static StoreEntryFragment newInstance(String param1, String param2) {
        StoreEntryFragment fragment = new StoreEntryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_store_entry, container, false);
        mStoreList = view.findViewById(R.id.store_entry_listview);
        mDBHlpr = new DBHelper(getActivity());
        mCsr = mDBHlpr.getStoreEntries();
        mSCA = new SimpleCursorAdapter(
                getActivity(),
                android.R.layout.simple_list_item_2,
                mCsr,
                new String[]{StoreEntry.COLUMN_PRODUCT_NAME,StoreEntry.COLUMN_PRODUCT_PRICE},
                new int[]{android.R.id.text1,android.R.id.text2}
        );
        mStoreList.setAdapter(mSCA);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
public class RecipeeEntryFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    DBHelper mDBHlpr;
    Cursor mCsr;
    SimpleCursorAdapter mSCA;
    ListView mRecipeeList;


    public RecipeeEntryFragment() {
    }

    public static RecipeeEntryFragment newInstance(String param1, String param2) {
        RecipeeEntryFragment fragment = new RecipeeEntryFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipee_entry, container, false);
        mRecipeeList = view.findViewById(R.id.recipee_entry_listview);
        mDBHlpr = new DBHelper(getActivity());
        mCsr = mDBHlpr.getRecipeeEntries();
        Log.d("RECIPEEFRAG","Number of rows in Cursor is " + String.valueOf(mCsr.getCount()));
        mSCA = new SimpleCursorAdapter(
                getActivity(),
                android.R.layout.simple_list_item_2,
                mCsr,
                new String[]{RecipeeEntry.COLUMN_RECIPEE_NAME,RecipeeEntry.COLUMN_RECIPEE_TYPE},
                new int[]{android.R.id.text1, android.R.id.text2}
                );
        mRecipeeList.setAdapter(mSCA);
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
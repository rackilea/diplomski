public class ContactsFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private CursorAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create adapter once
        Context context = getActivity();
        int layout = android.R.layout.activity_list_item;
        Cursor c = null; // there is no cursor yet
        int flags = 0; // no auto-requery! Loader requeries.
        mAdapter = new SimpleCursorAdapter(context, layout, c, FROM, TO, flags);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // each time we are started use our listadapter
        setListAdapter(mAdapter);
        // and tell loader manager to start loading
        getLoaderManager().initLoader(0, null, this);
    }

    // columns requested from the database
    private static final String[] PROJECTION = {
            ContactsContract.Contacts.HAS_PHONE_NUMBER,
            ContactsContract.Contacts._ID, // _ID is always required
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY // that's what we want to display
    };

    // and name should be displayed in the text1 textview in item layout

    public String[] phone = {ContactsContract.Contacts.HAS_PHONE_NUMBER};
    private static final String[] FROM = {ContactsContract.Contacts.DISPLAY_NAME_PRIMARY};
    private static final int[] TO = {android.R.id.text1};

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        // load from the "Contacts table"
        Uri contentUri = ContactsContract.Contacts.CONTENT_URI;

        // no sub-selection, no sort order, simply every row
        // projection says we want just the _id and the name column
        return new CursorLoader(getActivity(),
                contentUri,
                PROJECTION,
                ContactsContract.Contacts.HAS_PHONE_NUMBER + " =?", // This is selection string, were looking for records that HAS_PHONE_NUMER is 1
                new String[]{"1"}, // 1 means that contact has a phone number
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Once cursor is loaded, give it to adapter
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // on reset take any old cursor away
        mAdapter.swapCursor(null);
    }
}
public class AutoCompleteTextViewLoader implements LoaderManager.LoaderCallbacks<Cursor> {

    private final Context mContext;
    private final AutoCompleteTextView inputEmail;
    private final ArrayAdapter<String> adapter;
    private final LoaderManager loaderManager

    private final List<String> emails = new ArrayList<>();

    private final ContactPermissionRequester requester;

    public AutoCompleteLoader(Context context, AutoCompleteTextView textView, LoaderManager loaderManager) {
        this.mContext = context;

        this.inputEmail = textView;
        this.adapter = new ArrayAdapter<>(mContext,
                    android.R.layout.simple_dropdown_item_1line,      
                    emails);
        this.inputEmail.setAdapter(adapter);

        // This can throw a ClassCastException
        this.mRequester = (ContactPermissionRequester) context;

        this.loaderManager = loaderManager;
    }

    public List<String> getEmails() { return emails; }

    public void populate() {
        if (requester != null && !requester.mayRequestContacts()) {
            return;
        }

        loadManager.initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(mContext,
                // Retrieve data rows for the device user's 'profile' contact.
                ContactsContract.Data.CONTENT_URI, ProfileQueryInterface.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        // ArrayList not needed here
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // Add directly to adapter
            adapter.add(cursor.getString(ProfileQueryInterface.ADDRESS));
            cursor.moveToNext();
        }
        // Separate method was pointless
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }
}
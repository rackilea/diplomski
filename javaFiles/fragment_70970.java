public static ArrayList<ContactWrapper> fillContacts(Context c) {
    ArrayList<ContactWrapper> contacts = new ArrayList<ContactWrapper>();
    try {

        // private Uri uriContact;

        String contactName = null;
        String contactID = null;
        String contactNumber = null;

        ContactWrapper cWrapper;

        // getting contacts ID
        Cursor cursorID = c.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                new String[] { ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME }, null, null, null);

        if (cursorID.moveToFirst()) {
            do {
                contactID = cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts._ID));
                contactName = cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                contactNumber = DataUtil.retrieveContactNumber(c, contactID);

                if (contactNumber != null && (!contactNumber.equalsIgnoreCase("")) && (!contactNumber.equalsIgnoreCase(" "))) {
                    cWrapper = new ContactWrapper(contactID, contactName, contactNumber, 0);
                    contacts.add(cWrapper);

                    Log.d(c.getClass().getSimpleName(), "Contact ID: " + contactID);
                }

            } while (cursorID.moveToNext());
        }
        cursorID.close();

    } catch (Exception e) {
        e.printStackTrace();
        Log.e(c.getClass().getSimpleName(), "" + e.getMessage());
    }
    return contacts;
}
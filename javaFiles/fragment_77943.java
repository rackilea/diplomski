Cursor mRawContactCursor = context.getContentResolver().query(
            ContactsContract.RawContacts.CONTENT_URI,
            null,
            ContactsContract.Data.CONTACT_ID + " = ?",
            new String[] {ID},
            null);
    mRawContactCursor.moveToFirst();
    String rawId = mRawContactCursor.getString(mRawContactCursor.getColumnIndex(ContactsContract.RawContacts._ID));
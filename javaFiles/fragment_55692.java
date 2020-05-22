Uri uri = ContactsContract.Data.CONTENT_URI;
    String[] projection = new String[] {
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Event.CONTACT_ID,
            ContactsContract.CommonDataKinds.Event.START_DATE
    };

    String where =
            ContactsContract.Data.MIMETYPE + "= ? AND " +
            ContactsContract.CommonDataKinds.Event.TYPE + 
            "=" + ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY;
    String[] selectionArgs = new String[] { 
        ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE };
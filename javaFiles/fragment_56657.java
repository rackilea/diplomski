private static long getRawId(Context context, long contactId) {
        String selection = ContactsContract.RawContacts.CONTACT_ID + "='" + contactId + "'";
        try (Cursor cur = context.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{ContactsContract.RawContacts._ID}, selection, null, null)) {
            assert cur != null;
            if (cur.moveToNext()) { return cur.getLong(0);}
        }
        return 0;
    }
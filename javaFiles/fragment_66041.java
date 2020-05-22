public static boolean fromFavourites(Context context, String phoneNumber) {
    final String[] projection = new String[] {ContactsContract.PhoneLookup.STARRED};
    Uri lookupUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber)); //use this to look up a phone number
    Cursor cursor = context.getContentResolver().query(lookupUri, projection,  
                   ContactsContract.PhoneLookup.NUMBER + "=?", 
                    new String[] { phoneNumber}, null);
    if (cursor.moveToFirst()) {
        while (!cursor.isAfterLast()) {
            if (cursor.getInt(cursor.getColumnIndex(ContactsContract.PhoneLookup.STARRED)) == 1) {
            System.out.println("OUTPUT: " + cursor.getInt(0) );
            return true;
            }
            cursor.moveToNext();
        }   
    } 
    return false;
}
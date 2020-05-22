Cursor cursor = getContentResolver().query(
    ContactsContract.Data.CONTENT_URI, 
    null, 
    ContactsContract.CommonDataKinds.Phone.NUMBER+" LIKE %?", 
    new String[] { number }, 
    null);
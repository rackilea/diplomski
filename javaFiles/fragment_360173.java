public String createGroup(String name) {

    String[] GROUP_PROJECTION = new String[] { ContactsContract.Groups._ID,     ContactsContract.Groups.TITLE };

    try {
        ContentValues groupValues = null;
        ContentResolver cr = this.getContentResolver();
        groupValues = new ContentValues();
        groupValues.put(ContactsContract.Groups.TITLE, name);
        groupValues.put(ContactsContract.Groups.SHOULD_SYNC,true);
        cr.insert(ContactsContract.Groups.CONTENT_URI, groupValues);

    }
    catch(Exception e){
        Log.d("########### Exception :",""+e.getMessage());
        return "1";
    }

    String groupID = null;
    Cursor getGroupID_Cursor = null;
    getGroupID_Cursor = this.getContentResolver().query(ContactsContract.Groups.CONTENT_URI,  GROUP_PROJECTION, ContactsContract.Groups.TITLE+ "=?", new String[]{name}, null);

    getGroupID_Cursor.moveToFirst();
    groupID = (getGroupID_Cursor.getString(getGroupID_Cursor.getColumnIndex("_id")));

    return groupID;


}
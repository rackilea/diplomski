Cattle getCattle(int id){
    Cattle cattle = null;
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.query(TABLE_CATTLE,  new String[] 
            {KEY_ID,  KEY_TAG_ID, KEY_ALIAS, KEY_TIME, KEY_DATA}, KEY_ID + "=?",
            new String[] {String.valueOf(id) }, null, null, null, null);
    if(cursor!=null) {
        if (cursor.moveToFirst()) {
            cattle = new Cattle(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));
        }
        cursor.close();
    }
    db.close();//test
    return cattle;
}
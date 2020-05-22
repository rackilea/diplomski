Cursor cursor = null;
try {    
    cursor = SampleHelper.getHelper(mContext).getReadableDatabase().rawQuery("SELECT colA FROM table_name");
    if (cursor.moveToFirst()) {
        do {
            /**read the data here**/
        } while (cursor.moveToNext());
    }
}
finally {
    if(null != cursor)
        cursor.close();
}
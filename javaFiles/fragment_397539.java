public  Cursor queueAll(){
   String[] columns = new String[] {KEY_ID, KEY_RCODE, KEY_RNAME, KEY_OFNO};
   Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE2, columns,
        null, null, null, null, null);
   return cursor;
}
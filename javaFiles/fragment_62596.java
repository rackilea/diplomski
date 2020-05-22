private boolean tableExists() {
    Boolean exists = false;
    String query = "SELECT * FROM " + TABLE_NOTES;

    SQLiteDatabase db = this.getWritableDatabase();
    try{
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            exists = true;
        }else{
            exists = true;
        }
    }catch (Exception e){

    }
    return exists;

}
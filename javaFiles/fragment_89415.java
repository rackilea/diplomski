public boolean insertData(String Name,String Birthdate,String Area, String ID){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(ColunNameForName, Name);
    contentValues.put(ColunNameForBirthdate, Birthdate);
    contentValues.put(ColunNameForArea, Area);
    contentValues.put(ColunNameForID, ID);

    long result = db.insert(TABLE_NAME, null, contentValues);

    if(result == -1){
        return false;
    }
    else{
        return true;
    }
}
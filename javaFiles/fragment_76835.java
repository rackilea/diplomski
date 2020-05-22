public boolean insertData(String name, Integer age, Integer sex_male, Integer weight, Integer height, Integer trauma){
    boolean success = false;
    try{
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_AGE, age);
        contentValues.put(COL_GENDER, sex_male);
        contentValues.put(COL_WEIGHT, weight);
        contentValues.put(COL_HEIGHT, height);
        contentValues.put(COL_TRAUMA, trauma);
        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();

        if(result != -1) success = true;
    }
    catch(Exception ex){
        Log.e(TAG, ex.getMessage());
    }

    return success;
}
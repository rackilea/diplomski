ContentValues cv = new ContentValues();
    cv.put(SQLiteHelper.Table_Column_1_Name,NameHolder);
    cv.put(SQLiteHelper.Table_Column_2_PhoneNumber,NumberHolder);
    cv.put(SQLiteHelper.Table_Column_3_Date,DateHolder);
    cv.put(SQLiteHelper.Table_Column_4_Image,your_image_as_a_byte_array);
    long result = sqLiteDatabaseObj.insert(SQLiteHelper.TABLE_NAME,null,cv);
public void insertOrUpdateTheIncomeAndSavings(int income, int savings){
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

          Cursor cursor = sqLiteDatabase.rawQuery("select * from "+ItemEntry.TABLE_NAME2,null);
            if(cursor.moveToNext()){
            //update the values of first row here

            }else{
                //insert the value here
            }

            if(cursor!=null){
            cursor.close();
            }
           sqLiteDatabase.close();

        }
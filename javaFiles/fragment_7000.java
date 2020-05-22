try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            k = db.insertWithOnConflict("YOURDB",null, contentValues, SQLiteDatabase.CONFLICT_IGNORE);

            db.close();
        }
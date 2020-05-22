@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "Updating table from " + oldVersion + " to " + newVersion);


        if (oldVersion < 3){ // Here I SET 3. You should use your DB version . When-ever **`adding table`**  please increase DB version .
            db.execSQL(ALTER_USER_TABLE_1);
            db.execSQL(ALTER_USER_TABLE_2);
        }

    }
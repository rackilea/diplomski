// this cut down Insert time from 250-600ms to 14-30 ms.
    // with prgma syncronous set to off, this drops it down to 0.5ms/row for membernames
    final InsertHelper ih = new InsertHelper(database, SQLiteHelper.TABLE_MEMBERS);
    final int nameColumn = ih.getColumnIndex(SQLiteHelper.MEMBER_TABLE_MEMBERNAME);
    final long startTime = System.currentTimeMillis();

    try {
        database.execSQL("PRAGMA synchronous=OFF");
        database.setLockingEnabled(false);
        database.beginTransaction();
        for (int i = 0; i < Members.size(); i++) {
            ih.prepareForInsert();

            ih.bind(nameColumn, Members.get(i));

            ih.execute();
        }
        database.setTransactionSuccessful();
    } finally {
        database.endTransaction();
        database.setLockingEnabled(true);
        database.execSQL("PRAGMA synchronous=NORMAL");
        ih.close();
        if (Globals.ENABLE_LOGGING) {
            final long endtime = System.currentTimeMillis();
            Log.i("Time to insert Members: ", String.valueOf(endtime - startTime));
        }
    }
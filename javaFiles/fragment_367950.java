ContentValues contentvalue = new ContentValues();
contentvalue.put(TaskDatabaseHelper.FRND_USERNAME,uname); // column name : data..
contentvalue.put(TaskDatabaseHelper.FRND_FNAME, fname);
contentvalue.put(TaskDatabaseHelper.FRND_LNAME, lname);
contentvalue.put(TaskDatabaseHelper.FRND_EMAIL, email);

sqlitedb.insert(TaskDatabaseHelper.FRIENDS_TABLE_NAME, null, contentvalue); // adding data...
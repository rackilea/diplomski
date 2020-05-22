DictionaryOpenHelper myDictionary;
myDictionary = new DictionaryOpenHelper(this);
SQLiteDatabase db = myDictionary.getWritableDatabase();

//to enter values in the db
ContentValues values = new ContentValues();
values.put("name","Rhyno");
db.insert(nameOfTable, null, values);
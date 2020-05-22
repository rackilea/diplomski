PrayDBHelper mDBHelper = new PrayDBHelper(PrayActivity.this);
SQLiteDatabase db = mDBHelper.getWritableDatabase();
ContentValues cv = new ContentValues();
cv.put(prayEntry.DATE, getDate());
db.insert(prayEntry.TABLE_NAME, cv);
db.close();
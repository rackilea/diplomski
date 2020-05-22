public int updateScore(String name, int wynik) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(KEY_SERIES,wynik);
    int c = mDb.update(TABLE_CWICZENIA,contentValues, KEY_NAME + " = " + name , null);
    return c;
}
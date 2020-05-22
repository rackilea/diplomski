public long insert(long score, int percentage) { // Remove db parameter
    ContentValues values = new ContentValues();
    values.put(SCORE, score);
    values.put(PERCENTAGE, percentage);

    return db.insert(TABLE, null, values); // This will use the member variable
}
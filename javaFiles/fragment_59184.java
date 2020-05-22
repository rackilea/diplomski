public int save(AccountHolder_to acchold) {
    SQLiteDatabase db = dbHelper.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(DataBaseHelper.email, acchold.getA_email());
    values.put(DataBaseHelper.username, acchold.getA_username());
    values.put(DataBaseHelper.password, acchold.getA_password());
    values.put(DataBaseHelper.syncedURL, acchold.getA_syncedURL());
    values.put(DataBaseHelper.A_patientID, "");

    // Inserting Row
    long acc_Id = db.insert(dbHelper.accountHolder_Table, null, values);
    db.close(); // Closing database connection
    return (int) acc_Id;
}
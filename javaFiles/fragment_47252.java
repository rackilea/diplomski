public void createAccounts(Account mNewAccount) {
    SQLiteDatabase db = null;

    try {
        DataBaseOpenHelper dOpenHelper;
        dOpenHelper = new DataBaseOpenHelper(context,DB_NAME,DATABASE_VERSION);

        ContentValues values = new ContentValues();
        values.put("account_name", mNewAccount.getAccountName());
        values.put("account_number", mNewAccount.getAccountNumber());
        db = dOpenHelper.getWritableDatabase();
        db.insert(DBConstants.DB_TABLE_ACCOUNTS, null, values);

        // Here you notify the change when the database is updated
        context.getContentResolver().notifyChange(DB_TABLE_ACCOUNTS_URI, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
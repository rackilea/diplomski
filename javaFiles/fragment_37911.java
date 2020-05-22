public long insertTitle(String gqty, String nqty, String ddate) 
{
    open();
    ContentValues initialValues = new ContentValues();
    initialValues.put(KEY_GQTY, gqty);
    initialValues.put(KEY_NQTY, nqty);
    initialValues.put(KEY_DATE, ddate);
    return db.insert(DATABASE_TABLE, null, initialValues);
}
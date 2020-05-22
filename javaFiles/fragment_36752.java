@Override
public int bulkInsert(Uri uri, ContentValues[] values) {
    try {
        db.beginTransaction();
        String table = getTable(uri);
        for (ContentValues value : values)
            db.insert(table, null, value);
        db.setTransactionSuccessful();
    } catch (SQLException e) {
    } finally {
        db.endTransaction();
    }
    return values.length;   
}
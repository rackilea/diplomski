db.beginTransaction();
try {
    ...
    db.setTransactionSuccessful();
} finally {
    db.endTransaction();
}
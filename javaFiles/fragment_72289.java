database.beginTransaction();
try
{
    for (record : records)
        database.insert(...);

    database.setTransactionSuccessful();
}
finally
{
    database.endTransaction();
}
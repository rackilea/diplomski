@Override
public int bulkInsert(Uri uri, ContentValues[] values) {

    String table = getTable(uri);
    int count = 0;
    for (ContentValues value : values) 
        count += db.insert(table, "", value);

    return count;

}
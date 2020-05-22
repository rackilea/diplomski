if(curs!=null)
{
    List<Cursor> listCursor = new ArrayList<Cursor>();      
    curs.moveToFirst();

    if(curs.getCount()>=1)
    {
        do 
        {
            String strID = curs.getString(curs.getColumnIndex(KEY_NAME));
            String [] sqlSelect = {"0 _id", "TB", "Version", "Book", "Chapter", "NKJ"}; 
            String sqlTables = "hindibible";

            SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
            qb.setTables(sqlTables);

            StringBuilder strQuery = new StringBuilder();
            strQuery.append("ID = "+strID); 

            Cursor bible = qb.query(db, sqlSelect, strQuery.toString(), null,null, null,null);
            listCursor.add(bible);
        }while (curs.moveToNext());

        return listCursor;
    }
public void addValueTest(String tableName, String[] values)
{
    String sql = "";

    if (tableName.equalsIgnoreCase("TableA"))
    {
            sql = "insert into "+ tableName + " (TableA_FieldA, TableA_FieldB) values (?, ?);";
    }
    else if (tableName.equalsIgnoreCase("TableB"))
    {
            sql = "insert into "+ tableName + " (TableB_FieldA, TableB_FieldB, TableB_FieldC) values (?, ?, ?);";
    }

    //else if ...
    //else if ...
    //else if ...
    //else if ...

    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(sql, values);
    db.close();
}
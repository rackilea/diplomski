@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + TABLE_NAME + " (OID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "TxnNo TEXT, Name TEXT, Amount INTEGER,Date TEXT, Description TEXT,Description2 TEXT)");
    db.execsql("CREATE TRIGGER If NOT EXISTS increment_tax_number     AFTER INSERT ON Person_Table 
BEGIN
    UPDATE Person_Table SET TxnNo = 'Txn no '||new.OID WHERE OID =  new.OID;
END");
}
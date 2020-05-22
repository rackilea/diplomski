@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table IF EXISTS " + customer.Table_Name);
    db.execSQL("drop table IF EXISTS " + ticket.Table_Name);
    db.execSQL("DROP TRIGGER IF EXISTS setTicketAvailability_trigger");
    onCreate(db);
}
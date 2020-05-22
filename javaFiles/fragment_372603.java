mcursor.moveToFirst();

public void count(){
    SQLiteDatabase db = table.getWritableDatabase();
    String count = "SELECT count(*) FROM table";
    Cursor mcursor = db.rawQuery(count, null);
    mcursor.moveToFirst();
    int icount = mcursor.getInt(0);
    System.out.println("NUMBER IN DB: " + icount);
}
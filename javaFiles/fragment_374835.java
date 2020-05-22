public String getLoggedInStatus()
{
    SQLiteDatabase db = getReadableDatabase();
    String status="";
    String query = "SELECT * FROM  LoggedInStatus";   //LoggedInStatus is my table to store login status

    Cursor  cursor = db.rawQuery(query,null);

    if (cursor.moveToFirst) { //<<<<<<<<<< CHANGED
        cursor.moveToFirst();
        status = cursor.getString(0); 
    }
    cursor.close() //<<<<<<<<<< You should always close cursors when done with them
    return status;
}
COL_1="ID"
 COL_4="DATES"

     public int getDateId(String date){
int dateID=0;
String last_query = "SELECT " + COL_1  + " FROM " + TABLE_NAME  + " WHERE " + COL_4 + " = '" + date + "'";
Cursor c = database.rawQuery(last_query, null);
if (c != null && c.moveToFirst())
{
    dateID = c.getInt(0);
}
c.close();

return dateID;
}
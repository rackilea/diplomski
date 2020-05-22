public String fetchGroup(SQLiteDatabase inDatabase,  String valueCheck){

    String query = "SELECT COUNT(id) FROM groups WHERE groupname=\"" + valueCheck + "\"";

    Cursor  cursor = inDatabase.rawQuery(query, null);
    cursor.moveToFirst();
    int place = cursor.getInt(0);
    return String.valueOf(place);
}
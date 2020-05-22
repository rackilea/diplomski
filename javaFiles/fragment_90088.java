public ArrayList getAllScores() {

// Select All Query
String selectQuery = "SELECT  * FROM " + TABLE_DETAIL;

SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list


ArrayList<String>data=new ArrayList<>();

while (cursor.moveToNext()) {

    data.add(cursor.getString(1));


}
cursor.close();
db.close();
// return score array
return data;
}
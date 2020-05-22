public List<LatLng> getAllPositions() {
List<LatLng> positionList = new ArrayList<LatLng>();

Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME,
    allColumns, null, null, null, null, null);

cursor.moveToFirst();
while (!cursor.isAfterLast()) { 

    String positions = cursor.getString(1);
    double latitude = cursor.getColumnIndex("lat");
    double longitude = cursor.getColumnIndex("long");
    LatLng newLatLng = new LatLng(latitude, longitude);
    positionList.add(newLatLng);
    cursor.moveToNext();
}
// make sure to close the cursor
cursor.close();
return positionList;
}
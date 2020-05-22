public Cursor getId(String tableName)
    {

    String query = ("insert into trip tmid select mid from member");
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor c = db.rawQuery(query,null);
    return  c;
     }
//this in my main activity
//calling cursor
            public void onClick(View v) {
            long isInserted = myDb.createride(etfrom.getText().toString(),
                    etto.getText().toString(),
                    etdate.getText().toString(),
                    ettime.getText().toString(),
                    etpick.getText().toString(),
                    etcost.getText().toString(),
                    etseat.getText().toString());
            if (isInserted > 0){

                Cursor cursor = myDb.getId(myDb.TABLE_MEMBER);
                startManagingCursor(cursor);

                while(cursor.move(0)) {
                    int id = cursor.getInt(0);
                }
     //this is how i using to get value to table
        public long createride(String from_trip,String to_trip,String date,String time,String pickup,String cost,String seats) {

    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_FROM,from_trip);
    values.put(KEY_TO,to_trip);
    values.put(KEY_DATE,date);
    values.put(KEY_TIME,time);
    values.put(KEY_PICKUP,pickup);
    values.put(KEY_SEATS,seats);
    values.put(KEY_SEAT_COST,cost);

    long insertId = db.insert(TABLE_TRIP, null, values);

    return insertId;
}
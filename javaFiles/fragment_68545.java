public Cursor getLatestPrice() {
      SQLiteDatabase db = this.getReadableDatabase();

String[] projection = {
    COL_BID_PRICE,
    COL_BID_NAME
    };

Cursor res = db.query(
    TBL_BID,   // The table to query
    projection,             // The array of columns to return (pass null to get all)
    null,              // The columns for the WHERE clause
    null,          // The values for the WHERE clause
    null,                   // don't group the rows
    null,                   // don't filter by row groups
    null               // The sort order
    );

      return res;    
    }
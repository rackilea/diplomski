public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);

        //Example table 1 load data

        dbHelper.getWritableDatabase().delete(DBHelper.TABLE_NAME,null,null); // Empty table
        dbHelper.insertRow("Crafts", 2, 3, 0, 0, 0);
        dbHelper.insertRow("Arts", 1, 1, 1, 1, 1);
        dbHelper.insertRow("Science", 6, 3, 0, 0, 0);
        dbHelper.insertRow("Maths", 2, 3, 0, 0, 0);
        dbHelper.insertRow("Crafts2",2,3); //<<<<<<<<<< NULLS for a3-a5
        dbHelper.dumpTableToLog(DBHelper.TABLE_NAME); // Dump all table 1 contents to the Log

        Log.d("GETDATAREUSULT", getData(2, 3, 0, 0, 0));
        Log.d("GETDATAREUSULT", getData(1, 3, 0, 0, 0));

        //Example table 2 (with DEFAULT 0) (uses methods ending with 2)

        dbHelper.getWritableDatabase().delete(DBHelper.TABLE_NAME,null,null); // Empty table
        dbHelper.insertRow2("Crafts", 2, 3, 0, 0, 0);
        dbHelper.insertRow2("Arts", 1, 1, 1, 1, 1);
        dbHelper.insertRow2("Science", 6, 3, 0, 0, 0);
        dbHelper.insertRow2("Maths", 2, 3, 0, 0, 0);
        dbHelper.insertRow2("Crafts2",2,3); //<<<<<<<<<< NULLS for a3-a5
        dbHelper.dumpTableToLog(DBHelper.TABLE_NAME2); // Dump all table 2 contents to the Log

        Log.d("GETDATA2REUSULT", getData2(2, 3, 0, 0, 0));
        Log.d("GETDATA2REUSULT", getData2(1, 3, 0, 0, 0));
    }


    // To get data from DB by querying the items selected
    public String getData(int firstSelection, int secondSelection, int thirdSelection,
                          int fourthSelection, int fifthSelection) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String firstSelectionStr, secondSelectionStr, thirdSelectionStr, fourthSelectionStr, fifthSelectionStr;

        firstSelectionStr = Integer.toString(firstSelection);
        secondSelectionStr = Integer.toString(secondSelection);
        thirdSelectionStr = Integer.toString(thirdSelection);
        fourthSelectionStr = Integer.toString(fourthSelection);
        fifthSelectionStr = Integer.toString(fifthSelection);

        //String[] columns = {DBHelper.UID,DBHelper.CNAME};
        //Cursor cursor = db.query(DBHelper.TABLE_NAME,columns,null,null,null,null,null);
        String selectQuery = "SELECT * FROM " + DBHelper.TABLE_NAME + " WHERE " + DBHelper.FIRST_ATTRIBUTE + "=? "
                + " AND " + DBHelper.SECOND_ATTRIBUTE + "=? " + " AND " + DBHelper.THIRD_ATTRIBUTE + "=? " + " AND " + DBHelper.FOURTH_ATTRIBUTE + "=? "
                + " AND " + DBHelper.FIFTH_ATTRIBUTE + "=?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{firstSelectionStr, secondSelectionStr, thirdSelectionStr,
                fourthSelectionStr, fifthSelectionStr});
        StringBuilder buffer = new StringBuilder();
        while (cursor.moveToNext()) {
            buffer.append(cursor.getString(cursor.getColumnIndex(DBHelper.CNAME))).append(" ");
        }
        cursor.close(); //<<<<<<<<<< Should always close cursor when done with it.


        /*
        cursor.moveToFirst(); //<<<<<<<<<< SHOULD ALWAYS CHECK result of move false if unable true if able to move

        if (cursor != null) { //<<<<<<<<<< A cursor return from SQLiteDatabase meyhod will never be null, useless/dangerous

            int tresult = cursor.getCount();

            // Append every data together
            do {
                //int cursorID = cursor.getInt(cursor.getColumnIndex(DBHelper.UID));
                String chosenItem = cursor.getString(cursor.getColumnIndex(DBHelper.CNAME));
                buffer.append(chosenItem + " ");
            } while (cursor.moveToNext());
        }
        */
        /*while (cursor.moveToNext())
        {
            //int cursorID = cursor.getInt(cursor.getColumnIndex(DBHelper.UID));
            String chosenItem = cursor.getString(cursor.getColumnIndex(DBHelper.CNAME));
            buffer.append(chosenItem + " ");
        }*/

        return buffer.toString();
    }

    /**
     * Alternative using the convenience query method
     * @param firstSelection
     * @param secondSelection
     * @param thirdSelection
     * @param fourthSelection
     * @param fifthSelection
     * @return
     */
    public String getData2(int firstSelection, int secondSelection, int thirdSelection,
                          int fourthSelection, int fifthSelection) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String whereclause = DBHelper.FIRST_ATTRIBUTE + "=? AND " +
                DBHelper.SECOND_ATTRIBUTE + "=? AND " +
                DBHelper.THIRD_ATTRIBUTE + "=? AND " +
                DBHelper.FOURTH_ATTRIBUTE + "=? AND " +
                DBHelper.FIFTH_ATTRIBUTE + "=?"
                ;
        String[] whereargs = new String[]{
                String.valueOf(firstSelection),
                String.valueOf(secondSelection),
                String.valueOf(thirdSelection),
                String.valueOf(fourthSelection),
                String.valueOf(fifthSelection)}
                ;
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME2,
                null,
                whereclause,
                whereargs,
                null,null,null
        );
        StringBuilder buffer = new StringBuilder();
        while (cursor.moveToNext()) {
            buffer.append(cursor.getString(cursor.getColumnIndex(DBHelper.CNAME))).append(" ");
        }
        cursor.close(); //<<<<<<<<<< Should always close cursor when done with it.
        return buffer.toString();
    }
}
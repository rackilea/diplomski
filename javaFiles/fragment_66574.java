public class DBHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "Db1.sqlite";
    private static final int DATABASE_VERSION = 1;

    public AssetsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public List<String> getAllColleges(){
        List<String> colleges = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT * FROM colleges_list ORDER BY Organization_Name";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                colleges.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning colleges
        return colleges;
    }
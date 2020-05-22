public class VS_dbHelper {

    private final VS_dbConfig dbHelp;

    public VS_dbHelper(Context c) {
        dbHelp = new VS_dbConfig(c);
    } 

    public String sendData(String filePath) {
        // For example 
        SQLiteDatabase db = dbHelp.getWritableDatabase();
    }
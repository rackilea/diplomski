public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        Log.d("MAXNUMBER", getMaxNumber());
    } //<<<<<<<<<< FIX 1 closes the onCreate method

    public String getMaxNumber () {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query(DBHelper.TABLE_WORKOUT, new String[]
                        {"MAX(" + DBHelper.KEY_WONUMBER + ")"},
                //{"COALESCE(MAX(" + DBHelper.KEY_WONUMBER + "),0)"}, //Alternative will return 0 instead of null if no rows

        null, null, null, null, null);
        StringBuffer buffer = new StringBuffer(""); //FIX2 initialize buffer by adding buffer = new StringBuffer("")
        if (c.moveToFirst()) { // moveToFirst will return false if no row to move to so no need to check row count
            String max_id = c.getString(0);
            buffer.append(max_id); //FIX 1 introduces might not have been inittialized (buffer hasn't been inittialized)
        }
        c.close();
        db.close(); // can be inefficient to keep on opening and closing the database
        return buffer.toString();
    }
}
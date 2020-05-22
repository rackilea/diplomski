// All Static variables
// Database Version
private static final int DATABASE_VERSION = 1;

// Database Name
private static final String DATABASE_NAME = "demo_database";

// Contacts table name
private static final String TABLE_CONTACTS = "contacts";
private static final String TABLE_PROINFO = "proinfo";
private static final String TABLE_RETAPROINFO = "retaproinfo";

private static final String TABLE_ATTENDANCE = "attendance";

// Contacts Table Columns names
private static final String KEY_ID = "id";
private static final String KEY_STUDID = "studid";
private static final String KEY_AVAILABILITY = "availability";




private final ArrayList<Bean_attendance> att_list = new ArrayList<Bean_attendance>();





public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

SQLiteDatabase db;
Cursor cursor;



// Creating Tables
@Override
public void onCreate(SQLiteDatabase db) {

    String CREATE_CATEGORY_NAME_TABLE = "CREATE TABLE " + TABLE_ATTENDANCE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_STUDID + " TEXT,"
            + KEY_AVAILABILITY + " TEXT"  + ")";





    db.execSQL(CREATE_CATEGORY_NAME_TABLE);



}

// Upgrading database
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed

    int upgradeTo = oldVersion + 1;
    while (upgradeTo <= newVersion) {
        switch (upgradeTo) {
        case 1:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 2:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);

            break;
        case 3:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 4:

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 5:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 6:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 7:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 8:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 9:

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 10:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 11:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        case 12:


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);


            break;
        }
        upgradeTo++;
    }


    // Create tables again
    onCreate(db);
}

/**
 * All CRUD(Create, Read, Update, Delete) Operations
 */



public void Add_Attandance(Bean_attendance contact) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(KEY_STUDID, contact.getStud_id());
    values.put(KEY_AVAILABILITY, contact.getAvailability());


    // Inserting Row
    db.insert(TABLE_ATTENDANCE, null, values);
    db.close(); // Closing database connection
}





public ArrayList<Bean_attendance> Get_Attandance() {
    try {
        att_list.clear();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ATTENDANCE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Bean_attendance contact = new Bean_attendance();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setStud_id(cursor.getString(1));
                contact.setAvailability(cursor.getString(2));

                // Adding contact to list
                att_list.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        cursor.close();
        db.close();
        return att_list;
    } catch (Exception e) {
        // TODO: handle exception
        Log.e("all_attandance", "" + e);
    }

    return att_list;
}







public int Update_MainAttandnce(String availble,int id) {
    String countQuery = "UPDATE " + TABLE_ATTENDANCE + " SET " + KEY_AVAILABILITY
            + " = " + "\"" + availble + "\""  + " where " + KEY_ID + "=" + "\"" + id
            + "\"";
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    int count = cursor.getCount();
    cursor.close();
    // return count
    return count;

}



public void Delete_Attandance_main(int id) {
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_ATTENDANCE, KEY_ID + "=" + id, null);
    db.close();

}

public void Attandanceremove() {
    SQLiteDatabase db = this.getWritableDatabase();
    // context.deleteDatabase(DATABASE_NAME);

    db.execSQL("delete from " + TABLE_ATTENDANCE);

    // db.delete(DATABASE_TABLE, null, null);
}
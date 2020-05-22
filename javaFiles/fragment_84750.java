I've modified your code a little bit:

public ArrayList<String> getAllContacts() {
    ArrayList<String> array_list = new ArrayList<>();

    SQLiteDatabase db = this.getReadableDatabase();
    String selectQuery = "SELECT * FROM "+CONTACTS_TABLE_NAME;
    Cursor res =  db.rawQuery( selectQuery, null );

    //check if data exist, proceed
    if (res.moveToNext()){
        do{
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
        }while(res.moveToNext());
    }

    //remember to close cursor after use
    res.close();

    return array_list;
}


//void instead of boolean
public void insertContact (String name, String surname, String phone, String address,String postal) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(CONTACTS_COLUMN_NAME, name);
    contentValues.put(CONTACTS_COLUMN_SURNAME, surname);
    contentValues.put(CONTACTS_COLUMN_PHONE, phone);
    contentValues.put(CONTACTS_COLUMN_ADDRESS, address);
    contentValues.put(CONTACTS_COLUMN_POSTAL, postal);

    //throw if not inserted
    db.insertOrThrow("contacts", "", contentValues);
}
public boolean insertContact(String name, String email) {
SQLiteDatabase db = this.getWritableDatabase();

// Check if name exists
Cursor res =  db.rawQuery( "SELECT * FROM CONTACTS WHERE NAME = ? ", new String[]{ name } );

// If name doesn't exist -> add
if (res.getCount() == 0) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);

        contentValues.put("email", email);
        db.insert("contacts", null, contentValues);
        return true;
    }

    // else -> return false and print a Toast e.g.
    return false;
}
public DB_Place getDBPlace(String name) {
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.query(TABLE_DB_TORE_Eintrag, new String[] { KEY_ID,
                    KEY_PLACE_ID, KEY_NAME, KEY_LONGITUDE, KEY_LATITUDE, KEY_TOR }, KEY_TOR + "=?",
                    new String[]{name}, null, null, null, null);

    DB_Place place = null;

    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {

        place = new DB_Place(Integer.parseInt(cursor.getString(0)),
            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
    }

    return place;
}
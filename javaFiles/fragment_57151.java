Cursor cursor = db.rawQuery(...);
try {
    while (cursor.moveToNext()) {
        //Here you have to add the item in your array list

    }
} finally {
    cursor.close();
}
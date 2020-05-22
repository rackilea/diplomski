public HashMap<String, String> getUserDetails(){
    HashMap<String,String> user = null;
    String selectQuery = "SELECT  * FROM " + TABLE_LOGIN;

    try {
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    if (cursor != null){
    cursor.moveToFirst();
    if(cursor.getCount() > 0){
        user = new HashMap<String,String>();
        user.put("name", cursor.getString(1));
        user.put("position", cursor.getString(2));
        user.put("level", cursor.getString(3));
        user.put("email", cursor.getString(4));
        user.put("uid", cursor.getString(5));
        user.put("created_at", cursor.getString(6));
    }
}
} finally {
    cursor.close();
    db.close();
}

    return user;
}
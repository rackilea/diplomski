public Users getUserName(String m) {
    String name = null;
    String query = "SELECT name FROM users WHERE id_number = ?";
    Cursor cursor = aDatabase.rawQuery(query, new String[]{m});
    try {
        if (cursor.moveToFirst()) {
            name = cursor.getString(0);
        }
    } finally {
        cursor.close()
    }
    return name;
}
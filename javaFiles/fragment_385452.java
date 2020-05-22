public Cursor fetchSearch(String find) {
    String query = "SELECT name, power, set, color FROM cards WHERE name = '" + find + "%'";
    return mDb.rawQuery(query, null);
}

public Cursor fetchSearchColor(String find, String color) {
    String query = "SELECT name, power, set, color FROM cards WHERE name = '" + find + "%' AND color = '" + color + "'";
    return mDb.rawQuery(query, null);
}
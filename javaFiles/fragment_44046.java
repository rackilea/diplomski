if (DatabaseUtils.queryNumEntries(db, "Users",
                                  "email = ?", new String[] { email })) > 0) {
    // probably UPDATE?
    return true;
} else {
    db.execSQL("INSERT INTO Users(email, password, username) VALUES(?,?,?)",
               new Object[] { email, password, username });
    return false;
}
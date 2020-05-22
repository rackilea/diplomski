ArrayList<String> someUsers = new ArrayList<String>();

if (u.moveToFirst()) {
    do {
        String aUser = u.getString(u.getColumnIndex(KEY_USERNAME));
        someUsers.add(aUser);
    } while (u.moveToNext());
}
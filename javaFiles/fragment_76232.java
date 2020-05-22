public Cursor getOpenLockers() {
    Cursor c = ourDatabase.rawQuery("SELECT _id, number, status FROM "
            + DATABASE_TABLE + " WHERE status = 'open'", null);
    if (c != null) {
        c.moveToFirst();
    }

    return c;
}
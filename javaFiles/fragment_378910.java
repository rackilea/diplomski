public Cursor getSpalte(){
    String where= null;
    String Order = "_id DESC";
    Cursor c =  db.query(true, DATABASE_TABLE, KEY_KALOA, // hope KEY_KALOA is guarantied to be correct here
            where, null, null, null, Order, null);
    return c;
}
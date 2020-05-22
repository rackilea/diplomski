public long addItem(Item item){ //<<<<<<<<<< returns long (id assigned by SQLite)
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    //values.put(KEY_ID,item.getId()); //<<<<<<<<<< allow SQLite to assign id
    values.put(KEY_KIND,item.getKind());
    values.put(KEY_PUBLISHED,item.getPublished());
    values.put(KEY_UPDATED,item.getUpdated());
    values.put(KEY_ETAG,item.getEtag());
    values.put(KEY_URL,item.getUrl());
    values.put(KEY_SELFLINK,item.getSelfLink());
    values.put(KEY_CONTENT,item.getContent());
    values.put(KEY_LABELS,convertListToString(item.getLabels()));

    db.insert(TABLE_NAME,null,values);
    db.close();
}
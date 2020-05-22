getReadableDatabase().rawQuery(
    String.format(
        "SELECT %s, %s FROM %s", 
        DreamContract.Dream._ID, 
        DreamContract.Dream.COLUMN_NAME_DREAM_TITLE, 
        DreamContract.Dream.DREAM_TABLE_NAME
    ), 
    null
);
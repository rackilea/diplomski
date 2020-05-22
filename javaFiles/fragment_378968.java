String[] projection = new String[]{
            People.NAME,
            People.NUMBER
         };

    Cursor c = ctx.getContentResolver().query(People.CONTENT_URI, projection,
    null, null, People.NAME + " ASC");
    c.moveToFirst();
    int nameCol = c.getColumnIndex(People.NAME);
    int numCol = c.getColumnIndex(People.NUMBER);

    int nContacts = c.getCount();
    do{
        // Do your work here
    } while(c.moveToNext());
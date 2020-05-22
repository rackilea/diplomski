SQLiteDatabase database = this.getReadableDatabase();
   String selectQuery = "SELECT * FROM Note where Username " + " LIKE '%" + acc + "%'";
    Cursor cursor = database.rawQuery(selectQuery, null);
        int count = cursor.getCount();
        database.close();
        if(count==0)
        {
            return result;
        }
        else
        {
            if (cursor.moveToFirst()) {


                do {

                   Note_DTO note = new Note_DTO();
                note.setId(Integer.parseInt(cursor.getString(0)));
                note.setDate(cursor.getString(1));
                note.setUser(cursor.getString(2));
                note.setContent(cursor.getString(3));
                NoteList.add(note);
                } while (cursor.moveToNext());

            }
Cursor cursor = db.rawQuery(selectQuery, null);
    ArrayList<HashMap<String, String>> maplist = new ArrayList<HashMap<String, String>>();
    // looping through all rows and adding to list

    if (cursor.moveToFirst()) {
        do {
            HashMap<String, String> map = new HashMap<String, String>();
            for(int i=0; i<cursor.getColumnCount();i++)
            {
                map.put(cursor.getColumnName(i), cursor.getString(i));
            }

            maplist.add(map);
        } while (cursor.moveToNext());
    }
    db.close();
    // return contact list
    return maplist;
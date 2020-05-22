@Override
    public void onTextChanged (CharSequence s, int start, int before, int count) {
        if (s.length() == 0) { // if empty I show to user nothing
            adapter.clearAll();
            adapter.notifyDataSetChanged();
        } else {
            Cursor cursor = database.rawQuery("SELECT * FROM todo WHERE task LIKE '%" + String.valueOf(s) + "%'", null); // ask for data from database
            adapter.clearAll();
            if (cursor.moveToFirst()) { // if the response wasn't empty
                do {
                // add filter data in adapter and save adapter(notifyDataSetChanged();)
                    adapter.addTask(cursor.getString(cursor.getColumnIndex("task"))); 
                } while (cursor.moveToNext());
            }
            cursor.close();
            adapter.notifyDataSetChanged();
        }
    }
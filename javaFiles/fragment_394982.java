Cursor cursor = fetchOption(0);

if (cursor.moveToFirst()) // data?
   System.out.println(cursor.getString(cursor.getColumnIndex("title")); 

cursor.close(); // that's important too, otherwise you're gonna leak cursors
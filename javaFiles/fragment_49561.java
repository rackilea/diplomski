int count = 0;
if(null != cursor)
    if(cursor.getCount() > 0){
        cursor.moveToFirst();
        count = cursor.getInt(0);
    }
cursor.close();
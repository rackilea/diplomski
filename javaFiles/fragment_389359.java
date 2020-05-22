while (cursor.moveToNext()) {
        a = cursor.getString(0);
        if (a.equals(user_name)) {
            b = cursor.getString(1);
        }
     }
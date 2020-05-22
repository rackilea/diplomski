if(cursor.moveToFirst) {
        bear.setID(cursor.getInt(cursor.getColumnIndex(myDbHelper.COLUMN_ID)));
        bear.setbearname(cursor.getString(cursor.getColumnIndex(myDbHelper.COLUMN_BEARNAME)));
        bear.setstuffing(cursor.getInt(cursor.getColumnIndex(myDbHelper.COLUMN_STUFFING)));
        bear.setbearhealth(cursor.getInt(cursor.getColumnIndex(myhelper.COLUMN_BEARHEALTH)));
        bear.sethpcost(cursor.getInt(cursor.getColumnIndex(myDbHelper.COLUMN_HEALTHCOST)));
        bear.sethpcount(cursor.getInt(cursor.getColumnIndex(myhelper.COLUMN_HEALTHCOUNT))));
        bear.setbearattack(cursor.getInt(cursor.getColumnIndex(myDbHelper.COLUMN_BEARATTACK))));
    }
    cursor.close(); //<<< ADDED SHOULD ALWAYS CLOSE CURSORS WHEN DONE WITH THEM
    db.close();
    return bear;
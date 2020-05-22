if(null != cursor) {
        bear.setID(Integer.parseInt(cursor.getString(0)));
        bear.setbearname(cursor.getString(1));
        bear.setstuffing(Integer.parseInt(cursor.getString(2)));
        bear.setbearhealth(Integer.parseInt(cursor.getString(3)));
        bear.sethpcost(Integer.parseInt(cursor.getString(4)));
        bear.sethpcount(Integer.parseInt(cursor.getString(5)));
        bear.setbearattack(Integer.parseInt(cursor.getString(6)));
    }
db.close();
return bear;
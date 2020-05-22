public void insertData(){


        String time;
        Time now = new Time();
        now.setToNow();
        time = now.toString();

        values.put("ID", "2");
        values.put("LEFT_POSITION", xPosition);
        values.put("RIGHT_POSITION", xPosition);
        values.put("GPS", GPSposition);
        values.put("TIME", time);

        if(db!=null)        
            db.insert("baza", null, values);
        else
            Log.d("AppName","db is null);
}
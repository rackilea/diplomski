HashMap<String,String> map;
while(cursor.moveToNext())
        {
            map = new HashMap<String,String>();
            map.put("vehicle_type", cursor.getString(1));
            map.put("date", cursor.getString(3));
            lst_driver.add(map);
        }
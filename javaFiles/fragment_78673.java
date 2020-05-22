List<Map<String,String>> data = new ArrayList<Map<String,String>>();
 int iRow=c.getColumnIndex(DBHelper.ROWID);
    int is1=c.getColumnIndex(DBHelper.TITLE);
        int is2=c.getColumnIndex(DBHelper.AUTHOR);
            int is3=c.getColumnIndex(DBHelper.ISBN);

            for (c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                 sa=c.getString(is1);
                 sb=c.getString(is2);
                 sc=c.getString(is3);
                 Map<String,String> map = new HashMap<String,String>();
                 map.put("name",sa);
                 map.put("address",sb);
                 map.put("address2",sc);
                 data.add(map);
            }

return data;
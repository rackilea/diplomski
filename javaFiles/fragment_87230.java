for (int i = 0; i < jArray.length(); i++) {

     JSONObject json_data = jArray.getJSONObject(i);
     String[] strArray = new String[Column.values().length];
     for (Column column : Column.values()){
        strArray[column.ordinal()] = json_data.getString(column.getName());
     }
     dataList.add(strArray);

 }
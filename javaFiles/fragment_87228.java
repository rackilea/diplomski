for (int i = 0; i < jArray.length(); i++) {

     JSONObject json_data = jArray.getJSONObject(i);
     String[] strArray = new String[2];
     strArray[0] = json_data.getString("col1");
     strArray[1] = json_data.getString("col2");
     dataList.add(strArray);

 }
JSONArray json_array = new JSONArray(jArray);

    for (int i = 0; i < json_array.length() ; i++) {
              try{
                    JSONObject object1 = jsonArray.getJSONObject(i);
                    int id = object1.getInt("ID");
                    String itemDescription = object1.getString("Item Description");     
                    String link = object1.getString("Link");
                    .....//and so on        
                 }
              catch(Exception e){
                    e.printStackTrace();
                    }
                 }
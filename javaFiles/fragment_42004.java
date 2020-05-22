String s = "{\"Data\":[{\"user\":1,\"items\":[{\"item\":1},{\"item\":2},{\"item\":3},{\"item\":4}]},{\"user\":2,\"items\":[{\"item\":11},{\"item\":2},{\"item\":3},{\"item\":4}]},{\"user\":3,\"items\":[{\"item\":11},{\"item\":2},{\"item\":3},{\"item\":4}]}]}";
    JSONObject json = new JSONObject(s);
    JSONArray data = json.getJSONArray("Data");
    for(int i=0; i< data.length(); i++){
        JSONObject userData = data.getJSONObject(i);
        if(userData.getInt("user") ==2 ){
              JSONArray items = userData.getJSONArray("items");
              JSONObject item = items.getJSONObject(3);
              System.out.println("item#4: " + item.getInt("item"));
        }
    }
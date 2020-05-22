for(int i=0;i<videos.length();i++){                     
        Map<String, String> map = new TreeMap<String, String>();    
        JSONObject e = videos.getJSONObject(i);

        map.put("id",  String.valueOf(i));
        map.put("title",  e.getString("title"));
        map.put("description",  e.getString("description"));
        mylist.add(map);
    }
String s = "{menu:{\"1\":\"sql\", \"2\":\"android\", \"3\":\"mvc\"}}";
    JSONObject jObject  = new JSONObject(s);
    JSONObject  menu = jObject.getJSONObject("menu");

    Map<String,String> map = new HashMap<String,String>();
    Iterator iter = menu.keys();
    while(iter.hasNext()){
        String key = (String)iter.next();
        String value = menu.getString(key);
        map.put(key,value);
    }
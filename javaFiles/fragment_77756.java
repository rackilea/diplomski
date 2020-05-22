String sorting = "{\"state\":\"desc\"}";
JSONObject  filter = new JSONObject(sorting);

Map<String,String> map = new HashMap<String,String>();
Iterator iter = filter.keys();
while(iter.hasNext()){
    String key = (String)iter.next();
    String value = filter.getString(key);
    map.put(key,value);
}
JSONObject songs= json.getJSONObject("songs");
Iterator x = songs.keys();
JSONArray jsonArray = new JSONArray();

while (x.hasNext()){
    String key = (String) x.next();
    jsonArray.put(songs.get(key));
}
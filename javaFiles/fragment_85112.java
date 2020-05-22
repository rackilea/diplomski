HashSet<Map.Entry<String,JsonElement>> map = new HashSet<>();

for(Map.Entry<String,JsonElement> entry : json.entrySet()){
    if(entry != null) {
        map.put(entry.getKey(), jsonObject.get(entry.getKey()));
    }
}
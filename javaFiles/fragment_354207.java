public static String getCSVData() throws IOException, JSONException {
    Path jsonFile = Paths.get("json");
    String json = new String(Files.readAllBytes(jsonFile), StandardCharsets.UTF_8);
    JSONArray jsonArray = new JSONArray(json.trim());
    List<List<String>> jsonArrays = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
        List<String> jsonObjects = new ArrayList<>();
        JSONArray record = jsonArray.getJSONObject(i).getJSONArray("record");
        for (int i2 = 0; i2 < record.length(); i2++) {
            JSONObject jsonObject = record.getJSONObject(i2);
            if (i2 == 0) {
                jsonObjects.add(jsonObject.get("timeStamp").toString());
                jsonObjects.add(jsonObject.get("code").toString());
                jsonObjects.add(jsonObject.get("text").toString());
            } else {
                jsonObjects.add(jsonObject.get("hostname").toString());
                jsonObjects.add(jsonObject.get("address").toString());
                jsonObjects.add(jsonObject.get("type").toString());
                jsonObjects.add(jsonObject.get("priority").toString());
                jsonObjects.add(jsonObject.get("ttl").toString());
            }
        }
        jsonArrays.add(jsonObjects);
    }
    StringBuilder stringBuilder = new StringBuilder("timeStamp,code,text,hostname,address,type,priority,ttl,hostname,address,type,priority,ttl\n");
    for(List<String> arrays : jsonArrays){
        stringBuilder.append(StringUtils.join(arrays, ",")).append("\n");
    }
    return stringBuilder.toString().trim();
}
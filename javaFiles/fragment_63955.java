String jsonObject = "{\"dessert\": \"cookies\", \"tvShow\": \"survivor\", \"color\" : \"blue\"}";
String jsonArray = "[\"dessert\", \"place\", \"tvShow\"]";

Map<String, String> objMap = new Gson().fromJson(jsonObject, new TypeToken<HashMap<String, String>>() {}.getType());
List<String> arrayVals = new Gson().fromJson(jsonArray, new TypeToken<List<String>>(){}.getType());
for(Entry<String, String> entry : objMap.entrySet()) {
  for (String val : arrayVals) {
    if (entry.getKey().equals(val)) {
      System.out.println("Found value in key set: " + val);
    }
  }
}
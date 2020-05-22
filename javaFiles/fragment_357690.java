public static void main(String[] args) {
    String jsonArray = "{\"payments\":[{\"a\":\"11\",\"b\":\"21\",\"c\":\"34\",\"d\":\"0\"},{\"a\":\"54\",\"b\":\"66\",\"c\":\"21\",\"d\":\"76\"},{\"a\":\"34\",\"b\":\"23\",\"c\":\"43\",\"d\":\"88\"}]}";
    JsonObject jsonObject2 = new Gson().fromJson(jsonArray, JsonObject.class);
    JsonObject innerObj = new JsonObject();
    StringBuilder joinBuilder = new StringBuilder();
    Map<String, String> testMap = new LinkedHashMap<String, String>();
    JsonArray paymentsArray = jsonObject2.getAsJsonArray("payments");
    for (JsonElement jsonElement : paymentsArray) {
        Set<Entry<String, JsonElement>> elemEntry = ((JsonObject) jsonElement).entrySet();
        Iterator<Entry<String, JsonElement>> itr = elemEntry.iterator();
        while (itr.hasNext()) {
            Entry<String, JsonElement> entry = itr.next();
            testMap.put(entry.getKey(), entry.getValue().getAsString());
        }
        if (testMap.get("d").equals("0")) {
            testMap.clear();
        } else {
            joinBuilder.append(StringUtils.join(testMap.values(), ';')).append(",");
        }
    }
    joinBuilder.deleteCharAt(joinBuilder.length() - 1);
    innerObj.addProperty("payments", joinBuilder.toString());
    System.out.println(innerObj.toString());
}
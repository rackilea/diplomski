public static void main(String[] args) {
    String jsonData = "{\"data\":[{\"id\": \"123456\",\"from\": {\"name\": \"ABC\",\"id\": \"123\"},\"message\": \"isafh\",\"story\": \"Best Story\",\"properties\": [{\"name\": \"By\",\"text\": \"PROUD TO BE AN INDIAN\",\"href\": \"www.xyz.com\"}],\"privacy\": {\"value\": \"\"},\"type\": \"photo\",\"created_time\": \"2013-10-24T07:17:28+0000\",\"updated_time\": \"2013-10-24T07:17:28+0000\"},{\"id\": \"122423456\",\"from\": {\"name\": \"ABCaasd\",\"id\": \"124233\"},\"message\": \"isafh\",\"story\": \"Best nice Story\",\"properties\": [{\"name\": \"By\",\"text\": \"PROUD TO BE AN INDIAN\",\"href\": \"www.abc.com\"}],\"privacy\": {\"value\": \"\"},\"type\": \"photo\",\"created_time\": \"2013-10-24T07:17:28+0000\"}],\"next token\":\"1233\"}";
    List<String> messages = parse(jsonData);
    for (String message : messages) {
        System.out.println(message);
    }
}

public static List<String> parse(String jsonData) {
    List<String> messages = new ArrayList<String>();
    JsonElement jsonElement = new JsonParser().parse(jsonData);
    JsonObject jsonTopObject = jsonElement.getAsJsonObject();
    JsonArray jsonArray = jsonTopObject.getAsJsonArray("data").getAsJsonArray();
    Iterator<JsonElement> iterator = jsonArray.iterator();
    while (iterator.hasNext()) {
        JsonObject jsonObject = iterator.next().getAsJsonObject();
        messages.add(jsonObject.get("message").getAsString());
    }
    return messages;
}
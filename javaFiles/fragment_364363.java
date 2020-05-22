public static void main(String[] args) {
    String json = "{request_time: \"2018-03-13T00:59:44+00:00\",\n" + "stops: [\n" + "{\n"
        + "atcocode: \"370023715\",\n" + "mode: \"bus\",\n" + "name: \"AG1\",\n"
        + "stop_name: \"AG1\",\n" + "smscode: \"37023715\",\n" + "bearing: \"N\",\n"
        + "locality: \"Sheffield Centre\",\n" + "indicator: \"AG1\",\n" + "longitude: -1.46616,\n"
        + "latitude: 53.38248,\n" + "distance: 57\n" + "},\n" + "{\n" + "atcocode: \"370027281\",\n"
        + "mode: \"bus\",\n" + "name: \"AG12\",\n" + "stop_name: \"AG12\",\n"
        + "smscode: \"37027281\",\n" + "bearing: \"N\",\n" + "locality: \"Sheffield Centre\",\n"
        + "indicator: \"AG12\",\n" + "longitude: -1.46583,\n" + "latitude: 53.38228,\n"
        + "distance: 77\n" + "}\n" + "]\n" + "}";

    JsonParser parser = new JsonParser();
    JsonElement element = parser.parse(json);

    if (element.isJsonObject()) {
      JsonObject bus = element.getAsJsonObject();

      JsonArray array = bus.getAsJsonArray("stops");
      for (int i = 0; i < array.size(); i++) {
        System.out.println(((JsonObject) array.get(i)).get("locality"));
        System.out.println(((JsonObject) array.get(i)).get("atcocode"));
      }
    }
  }
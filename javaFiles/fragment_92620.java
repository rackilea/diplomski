public class Test {
  String x;
  Integer y;

  public static void main(String[] args) {
    Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Object.class, new JsonDeserializer<Object>() {
      @Override
      public Object deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        Set<Entry<String, JsonElement>> values = arg0.getAsJsonObject().entrySet();
        System.out.println(values);

        return null;
      }

    }).create();

    gson.fromJson("{'x':'AA','y':5}", Test.class);
  }
}
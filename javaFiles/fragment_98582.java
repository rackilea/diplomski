public static void parseJSON(String jsonString) {
  Gson gsonParser = new Gson();
  Type collectionType = new TypeToken<Asking>(){}.getType();
  Asking gsonResponse = gsonParser.fromJson(jsonString, collectionType);
  System.out.println(gsonResponse);
}
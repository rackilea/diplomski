String json="[{\"id\":1,\"quantity\":2,\"name\":\"apple\"}, {\"id\":3,\"quantity\":4,\"name\":\"orange\"}]";

GsonBuilder gsonBuilder = new GsonBuilder();

gsonBuilder.registerTypeAdapter(new TypeToken<Map <String, Object>>(){}.getType(),  new MapDeserializerDoubleAsIntFix());

Gson gson = gsonBuilder.create();
List<Map<String, Object>> l = gson.fromJson(json, new TypeToken<List<Map<String, Object>>>(){}.getType() );

for(Map<String, Object> item : l)
    System.out.println(item);

String serialized = gson.toJson(l);
System.out.println(serialized);
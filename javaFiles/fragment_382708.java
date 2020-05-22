JsonbConfig jsonbConfig = new JsonbConfig()
   .withPropertyNamingStrategy(
     PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);
Map<String, Object> objectMap = new HashMap<>();
objectMap.put("c1", c1);
objectMap.put("c2", c2);
String json = JsonbBuilder.create(jsonbConfig).toJson(objectMap);
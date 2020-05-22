entityClasses = new HashMap<String, TypeToken>();
entityClasses.put("EntityType1", new TypeToken<ArrayList<EntityType1>>(){});

...
String type = "EntityType1"; // I already can fetch this.
final TypeToken typeToken= entityClasses.get(type);
new Gson().fromJson(entityJSON, typeToken.getType());
JsonObject object1 = ...;
JsonObject object2 = ...;
String [] names1 = { ... };
String [] names2 = { ... };

JsonObjectBuilder builder = Json.createObjectBuilder();
for(String name: names1)
  builder.add(name, object1.getString(name));
for(String name: names2)
  builder.add(name, object2.getString(name));
JsonObject newObject = builder.build();
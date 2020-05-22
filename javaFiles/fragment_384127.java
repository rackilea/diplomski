GsonBuilder builder = new GsonBuilder();

// Register custom deserializer for CheckInterface.class
builder.registerTypeAdapter(CheckInterface.class, new CheckInterfaceDeserializer());
Gson gson = builder.create();

CheckInterface[] result2 = gson.fromJson(json, CheckInterface[].class);
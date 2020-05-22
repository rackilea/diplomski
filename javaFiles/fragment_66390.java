GsonBuilder builder = new GsonBuilder();
builder.registerTypeAdapter(Profile.class, new ProfileJsonDeserializer());
Gson gson = builder.create();

JsonEntity jsonEntity = gson.fromJson(new FileReader("/tmp/json.txt"),
        JsonEntity.class);
System.out.println(jsonEntity);
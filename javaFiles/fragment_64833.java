SimpleModule useImmutableList = new SimpleModule("UseImmutableList");
useImmutableList.addAbstractTypeMapping(List.class, ImmutableList.class);

GuavaModule module = new GuavaModule();

ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(module);
mapper.registerModule(useImmutableList);

String json = "{\"ints\":[1,2,3,4]}";

System.out.println(mapper.readValue(json, Pojo.class));
String json = "{\"1\":{\"id\":\"1\",\"name\":\"some object\"},\"5\":{\"id\":\"2\",\"name\":\"another object\"}}";

ObjectMapper mapper = new ObjectMapper();

// create your map type <String, Item>
TypeFactory typeFactory = mapper.getTypeFactory();
MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Item.class);
HashMap<String, Item> map = mapper.readValue(json, mapType);

// get the list
List<Item> list = new ArrayList<Item>(map.values());

System.out.println(list);
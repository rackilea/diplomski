ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new GuavaModule());

String json = "{\"ints\":[1,2,3,4]}";

System.out.println(mapper.readValue(json, Pojo.class));
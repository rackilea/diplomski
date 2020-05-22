ObjectMapper mapper = new ObjectMapper();
SimpleModule module = new SimpleModule();
module.addDeserializer(Response.class, new ResponseDeserializer());
mapper.registerModule(module);

Response resp = mapper.readValue(myjson, Response.class);
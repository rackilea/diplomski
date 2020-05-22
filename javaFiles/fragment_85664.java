// setup ObjectMapper 
ObjectMapper mapper = new ObjectMapper();
mapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
SimpleModule module = new SimpleModule();
module.addDeserializer(MyPOJO.class,new MyPojoDeserializer() );
mapper.registerModule(module);

// use
mapper.readValue(json, MyPOJO.class);
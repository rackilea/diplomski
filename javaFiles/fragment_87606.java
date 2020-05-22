ObjectMapper mapper = new ObjectMapper();

 SimpleModule module = new SimpleModule();
 module.addSerializer(new CustomSerializer(SomeId.class));       
 mapper.registerModule(module);

 SomeDTO dto = new SomeDTO();
 dto.id = new SomeId(123);     
 String serialized = mapper.writeValueAsString(dto);
 System.out.println(serialized);             // output : {"id":123}
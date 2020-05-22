byte[] mapData = Files.readAllBytes(Paths.get("process.txt"));

ObjectMapper objectMapper=new ObjectMapper();
 //add this line  
objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);    

List<MyClass> myObjects = mapper.readValue(mapData , mapper.getTypeFactory().constructCollectionType(List.class, MyClass.class));
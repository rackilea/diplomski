JsonFactory factory = new JsonFactory(); 
ObjectMapper mapper = new ObjectMapper(factory); 
TypeReference<HashMap<String,Object>> typeRef 
        = new TypeReference<HashMap<String,Object>>() {};

HashMap<String,Object> o = mapper.readValue(inputFile, typeRef);
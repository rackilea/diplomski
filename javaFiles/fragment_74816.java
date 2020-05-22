ObjectMapper mapper = new ObjectMapper();
TypeReference<HashMap<String, Object>> type = 
    new TypeReference<HashMap<String, Object>>() {};

Map<String, Object> leftMap = mapper.readValue(leftJson, type);
Map<String, Object> rightMap = mapper.readValue(rightJson, type);
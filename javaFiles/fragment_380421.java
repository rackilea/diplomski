Map<String,String> map = new HashMap<String,String>();
  ObjectMapper mapper = new ObjectMapper();

  //convert JSON string to Map
  map = mapper.readValue((String)jsonarray.get(word0), new TypeReference<HashMap<String,String>>(){});

  System.out.println(map);
  System.out.println(map.get("choice"));
  System.out.println(map.get("score"));
ObjectMapper mapper = new ObjectMapper();

Map<String, Object> map = new HashMap<String, Object>();

String json = jsonArray.toString();
map.put("locations", json);

json = mapper.writeValueAsString(map);
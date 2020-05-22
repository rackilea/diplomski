List<String> jsonStrList = Arrays.asList("{\"a\":\"test1\",\"b\":\"test2\"}","{\"b\":\"test3\",\"c\":\"test4\"}");

ObjectMapper mapper = new ObjectMapper();
Map<String, Object> jsonMap = new HashMap<>();
for (String jsonStr : jsonStrList) {
    Map<String, String> jsonContent = mapper.readValue(jsonStr, Map.class);
    jsonContent.forEach((k,v) -> {
        if (jsonMap.containsKey(k)) {
            if (jsonMap.get(k) instanceof String) {
                List<String> content = new ArrayList<>();
                content.add(jsonMap.get(k).toString());
                content.add(v);
                jsonMap.put(k, content);
            } else {
                jsonMap.put(k, ((ArrayList) jsonMap.get(k)).add(v));
            }
        } else {
            jsonMap.put(k, v);
        }
    });
}
System.out.println(jsonMap.toString());
System.out.println(new ObjectMapper().writeValueAsString(jsonMap).toString());
ObjectMapper mapper = new ObjectMapper();

Map<String, Map<String, String>> map = mapper.readValue(new File("X:/test.json"), Map.class);
Map<String, String> result = new HashMap<String, String>();
for (Entry<String, Map<String, String>> entry : map.entrySet()) {
    result.putAll(entry.getValue());
}

System.out.println(mapper.convertValue(result, MyPojo.class));
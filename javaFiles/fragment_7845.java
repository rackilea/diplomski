ObjectMapper mapper = new ObjectMapper();
SplunkResponse response = mapper.readValue(jsonStr, SplunkResponse.class);
Map<String, Object> resultMap = new HashMap<>();
for (int row = 0; row < response.getRows().size(); row++) {
    for (int idx = 0; idx < response.getRows().get(row).size(); idx++) {
        resultMap.put(response.getFields().get(idx), response.getRows().get(row).get(idx));
    }
}

System.out.println(mapper.writeValueAsString(resultMap));
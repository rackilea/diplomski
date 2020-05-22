ObjectMapper mapper = new ObjectMapper();
JsonNode jsonTree = mapper.readTree(json);

ArrayNode valuesArray = (ArrayNode) jsonTree.get("values");

List<Map<String, String>> spells = new ArrayList<Map<String, String>>();
Map<String, String> spellMap = null;

for (int i = 1; i < valuesArray.size(); i++) {
    ArrayNode valuesItemArray = (ArrayNode) valuesArray.get(i);

    spellMap = new HashMap<String, String>();
    spellMap.put("name", valuesItemArray.get(0).asText());
    spellMap.put("school", valuesItemArray.get(1).asText());
    spellMap.put("subschool", valuesItemArray.get(2).asText());
    spellMap.put("descriptor", valuesItemArray.get(3).asText());

    spells.add(spellMap);
}
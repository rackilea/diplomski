ObjectMapper mapper = new ObjectMapper();
JsonNode jsonTree = mapper.readTree(json);

JsonNode valuesArray = jsonTree.get("values");

// each array in values
for (JsonNode valuesItemArray : valuesArray) {
    // each sub-array
    for (JsonNode valuesItem : valuesItemArray) {
        // valuesItem is name, school, etc..
    }
}
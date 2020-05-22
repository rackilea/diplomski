import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public void mask() throws IOException {
String jsonString = "{\n" +
            "    \"key1\":\"value1\",\n" +
            "    \"key2\":\"value2\",\n" +
            "    \"key3\":\"value3\"\n" +
            "}";
    Map<String, Object> map;    

    // Convert json to map
    ObjectMapper mapper = new ObjectMapper();
    try {
        TypeReference ref = new TypeReference<Map<String, Object>>() { };
        map = mapper.readValue(jsonString, ref);
    } catch (IOException e) {
        System.out.print("cannot create Map from json" + e.getMessage());
        throw e;
    }

    // Process map
    if(map.containsKey("key2")) {
        map.put("key2","xxxxxxxxx");
    }

    // Convert back map to json
    String jsonResult = "";
    try {
        jsonResult = mapper.writeValueAsString(map);
    } catch (IOException e) {
        System.out.print("cannot create json from Map" + e.getMessage());
    }

    System.out.print(jsonResult);
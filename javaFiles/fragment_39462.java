public class MyClass {

    private ObjectNode jsonObj;

    public ObjectNode getJson() {
      ObjectMapper mapper = new ObjectMapper();
      // some code to generate the Object user...
      JsonNode jsonNode = mapper.valueToTree(user);
      if (jsonNode.isObject()) {
        jsonObj = (ObjectNode) jsonNode;
        return jsonObj;
      }
      return null;
    }
}
final ObjectMapper objectMapper = new ObjectMapper();
final MyClass myClass = new MyClass();
myClass.foo = "bar";

// Serialize
final String json = objectMapper.writeValueAsString(myClass);

// Deserialize
final JsonNode jsonNode = objectMapper.readTree(json);

// Get the @type
final String type = jsonNode.get("@type").asText();

// Create a Class-object
final Class<?> cls = Class.forName(type);

// And convert it
final Object o = objectMapper.convertValue(jsonNode, cls);

System.out.println(o.getClass());
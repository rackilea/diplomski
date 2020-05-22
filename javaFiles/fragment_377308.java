final JsonNodeFactory factory = JsonNodeFactory.instance;

final ObjectNode node = factory.objectNode();

final ObjectNode child = factory.objectNode(); // the child

child.put("message", "test");

// etc etc

// and then:

node.set("notification", child); // node.put(String, ObjectNode) has been deprecated
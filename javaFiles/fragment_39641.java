final ObjectMapper mapper = new ObjectMapper();

final JsonNode node = mapper.readTree(yourInput);

// Access members:

node.get(0); // access node 0 of an array

for (final JsonNode entry: node) {
    ... // cycle through array nodes
}

node.get("foo"); // access property "foo" of an object

node.get("foo").getTextValue(); // access as a text

// etc etc
byte[] jsonData = Files.readAllBytes(Paths.get("volumes.json"));
ObjectMapper objectMapper = new ObjectMapper();
JsonNode rootNode = objectMapper.readTree(jsonData);
String authorName = "Joshua Bloch"; // author name to find
JsonNode items = rootNode.path("items");
Iterator<JsonNode> elements = items.elements();

while(elements.hasNext()){
    JsonNode isbn = elements.next();
    if(isbn.has("volumeInfo")) {
        JsonNode volumeInfo = isbn.path("volumeInfo");
        if(volumeInfo.has("authors")) {
            JsonNode authors = volumeInfo.path("authors");
            if(authors.toString().contains(authorName)) {
                // Print complete book JSON value
                System.out.println(isbn.toString());
            }
        }

    }
}
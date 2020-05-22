Sring json = "[1, 2, 3]"; // an array in JSON
try {
    final JsonParser parser = new ObjectMapper().getFactory().createParser(json);
    while (parser.nextToken() != null) {
    }
    System.out.println("Probably JSON!");
} catch (Exception e) {
    System.out.println("Definitely not JSON!");
}
public static void validateJSON(String json) throws IOException {
    JsonFactory jsonFactory = new JsonFactory();
    try (JsonParser jsonParser = jsonFactory.createParser(json)) {
        if (jsonParser.nextToken() == null)
            throw new IOException("No JSON root element");
        if (jsonParser.skipChildren().nextToken() != null) {
            JsonLocation loc = jsonParser.getTokenLocation();
            throw new IOException("Multiple JSON root elements" +
                                  " at line " + loc.getLineNr() +
                                  ", column " + loc.getColumnNr());
        }
    }
}
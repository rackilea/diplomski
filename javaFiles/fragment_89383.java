String string = "{\"foo\":\"bar\"}"
JsonParser jsonParser = new JsonParser();
try {
    jsonParser.parse(string);       // valid JSON
} catch (JsonSyntaxException ex) { 
    /* exception handling */        // invalid JSON
}
JsonNode json = request().body().asJson();
Logger.info("JSON : " + json.findPath("in").findPath("id"));
Logger.info("JSON : " + json.findValues("in"));
List<JsonNode> ins = new org.json.simple.JSONArray();
ins = json.findValues("in");

for (final JsonNode objNode : ins) {

    for (final JsonNode element : objNode) {
        Logger.info(">>>>>" + element.findPath("id"));
        //create my object for database
    }
}
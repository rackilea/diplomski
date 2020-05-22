SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

// from Map to XContent
XContentBuilder builder = ... // see above
// from XContent to JSON
String json = new String(builder.getBytes(), "UTF-8");
// use JSON to populate SearchSourceBuilder
JsonXContent parser = createParser(JsonXContent.jsonXContent, json));
sourceBuilder.parseXContent(new QueryParseContext(parser));
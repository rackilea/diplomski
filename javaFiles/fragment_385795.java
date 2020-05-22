final ObjectMapper mapper = new ObjectMapper();

final JsonNode input = mapper.readTree(...);

final JsonNode results = input.get("SearchResponse").get("Web").get("Results");

/*
 * Yes, this works: JsonNode implements Iterable<JsonNode>, and this will
 * cycle through array elements
 */
for (final JsonNode element: results) {
    // do whatever with array elements
}
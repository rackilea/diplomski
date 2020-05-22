String urlTemplate = "https://example.com/hotels/42?param1={p1}&param2={p2}";

String url = UriComponentsBuilder.fromHttpUrl(urlTemplate)
        .buildAndExpand("value1", "value2")
        .toUriString();

// Or:
String url = UriComponentsBuilder.fromHttpUrl(urlTemplate)
        .buildAndExpand(Map.of("p1", "value1",
                               "p2", "value2"))
        .toUriString();
UriTemplate template = UriTemplate.fromTemplate(
    "http://example.com/widgets/{widgetId}{?attr*}");
template.set("attr", Arrays.asList(1, 2, 3));
String expanded = template.expand();
assertEquals("http://example.com/widgets/?attr=1&attr=2&attr=3", 
    expanded);
String url = "http://example.com/path/to/my/thing/";
String parameter = "%2F";
UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path(parameter);
UriComponents components = builder.build(true);
URI uri = components.toUri();
System.out.println(uri); // prints "http://example.com/path/to/my/thing/%2F"
public static void main(String[] args) {
    String template = "http://example.com/name/{name}/age/{age}";
    UriTemplate uriTemplate = new UriTemplate(template);
    String uri = "http://example.com/name/Bob/age/47";
    Map<String, String> parameters = new HashMap<>();

    // Not this method returns false if the URI doesn't match, ignored
    // for the purposes of the this blog.
    uriTemplate.match(uri, parameters);
    System.out.println(parameters);
    parameters.put("name","Arnold");
    parameters.put("age","110");

    UriBuilder builder = UriBuilder.fromPath(template);
    // Use .buildFromMap()
    URI output = builder.buildFromMap(parameters);
    System.out.println(output.toASCIIString());

}
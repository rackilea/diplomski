URIBuilder builder = new URIBuilder();
    builder.setScheme("https");
    builder.setHost(HOSTNAME);
    builder.setPath(SERVLET);   
    builder.setPort(443);
    builder.build();
    return builder;
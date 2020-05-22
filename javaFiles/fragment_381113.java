URI uri = new URIBuilder()
    .setScheme("http")
    .setHost("www.google.com")
    .setPath("/search")
    .setParameter("q", "httpclient")
    .setParameter("btnG", "Google Search")
    .setParameter("aq", "f")
    .setParameter("oq", "")
    .build();    // the build method creates a new URI instance behind the scenes
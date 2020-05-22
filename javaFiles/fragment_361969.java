if (!url.getPath().startsWith("/")) {
    // relative URL => make it processed relatively to the root URL of the META-INF/persistence.xml
    // This means that rootUrl has a META-INF directory (but the rootUrl has no META-INF in path).
    // See JPA 2.1 specification page 366-368: http://download.oracle.com/otn-pub/jcp/persistence-2_1-fr-eval-spec/JavaPersistence.pdf
    // Note: while the solution looks smart, the getNonRootUrls may include more
    // than the <jar-file>. Thus, it may have side effects.
    try {
        URL absoluteUrl = new URL(environment.getRootUrl(),url.getPath());
        url=absoluteUrl;
    } catch (MalformedURLException e) {
        throw new RuntimeException("cannot make the relative URL as absolute:"+url);
    }
}
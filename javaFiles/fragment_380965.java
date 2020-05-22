private String getUrlWithoutParameters(String url) throws URISyntaxException {
    URI uri = new URI(url);
    return new URI(uri.getScheme(),
                   uri.getAuthority(),
                   uri.getPath(),
                   null, // Ignore the query part of the input url
                   uri.getFragment()).toString();
}
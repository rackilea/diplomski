private static URL encodeUrl(URL u) {
    try {
        //  odd way to encode urls, but it works!
        final URI uri = new URI(u.getProtocol(), u.getUserInfo(), u.getHost(), u.getPort(), u.getPath(), u.getQuery(), u.getRef());
        return new URL(uri.toASCIIString());
    } catch (Exception e) {
        return u;
    }
}
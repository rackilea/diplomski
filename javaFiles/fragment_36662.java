public static boolean validateHTTP_URI(String uri) {
    final URL url;
    try {
        url = new URL(uri);
    } catch (Exception e1) {
        return false;
    }
    return "http".equals(url.getProtocol());
}
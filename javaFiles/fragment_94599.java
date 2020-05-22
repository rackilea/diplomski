static boolean usesHttps(final String urlWithoutProtocol) throws IOException {
    try {
        Jsoup.connect("http://" + urlWithoutProtocol).get();
        return false;
    } catch (final IOException e) {
        Jsoup.connect("https://" + urlWithoutProtocol).get();
        return true;
    }
}
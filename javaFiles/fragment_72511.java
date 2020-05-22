try (
    final InputStream in = myUrl.openStream();
    final Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
) {
    // read from the reader here
}
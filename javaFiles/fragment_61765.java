public static List<URL> getResources(final String path) throws IOException {
    final ClassLoader loader = Thread.currentThread().getContextClassLoader();
    try (
            final InputStream is = loader.getResourceAsStream(path);
            final InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            final BufferedReader br = new BufferedReader(isr)) {
        return br.lines()
                .map(l -> path + "/" + l)
                .map(r -> loader.getResource(r))
                .collect(toList());
    }
}
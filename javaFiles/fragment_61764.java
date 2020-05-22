final ClassLoader loader = Thread.currentThread().getContextClassLoader();
try(
        final InputStream is = loader.getResourceAsStream("text");
        final InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        final BufferedReader br = new BufferedReader(isr)) {
    br.lines().forEach(System.out::println);
}
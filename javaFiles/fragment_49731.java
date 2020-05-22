class Wrapper {
  public static void main(String... argv) throws Exception {
    // Do some initialization or other work.
    Class<?> delegate = Class.forName(argv[0]);
    Method main = delegate.getMethod("main", String[].class);
    main.apply(null, Arrays.asList(argv).subList(1, argv.length).toArray(argv));
  }
}
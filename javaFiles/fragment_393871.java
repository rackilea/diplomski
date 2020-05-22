try (Stream<String> stream = Files.lines(Paths.get(""))) {
    stream.map(PATTERN::matcher)
          .filter(Matcher::find)
          .map(m -> new String[] { m.group(1), m.group(2) })
          .forEach(a -> System.out.println(Arrays.toString(a)));
} catch (IOException e) {
    e.printStackTrace();
}
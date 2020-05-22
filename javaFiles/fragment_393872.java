try (Stream<String> stream = Files.lines(Paths.get(""))) {
    stream.map(PATTERN::matcher)
          .flatMap(m -> {
              List<String[]> list = new ArrayList<>();
              while (m.find()) {
                  list.add(new String[] { m.group(1), m.group(2) });
              }
              return list.stream();
          })
          .forEach(a -> System.out.println(Arrays.toString(a)));
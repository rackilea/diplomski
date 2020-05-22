Stream<String> strings = Stream.of("kgj", "def", "dgh");

  strings.distinct().collect(Collector.of(
          HashMap::new,
          (BiConsumer<Map<String, Long>, String>) (map, str) -> {
            map.put(str, Long.valueOf(map.size() + 1));
          },
          (left, right) -> {
            long s = left.size();
            right.entrySet().forEach(e -> left.put(e.getKey(),
                                                   Long.valueOf(
                                                           e.getValue()
                                                                   .longValue()
                                                           + s)));
            return left;
          })).forEach((k, v) -> System.out.println("k = " + k + " / v = " + v));
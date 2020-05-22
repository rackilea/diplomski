Map<String, String> srcMap = Map.of("A", "a", "B", "b", "C", "c");

    ImmutableMap<String, String> map = ImmutableMap.<String, String> builder()
            .putAll(srcMap)
            .put("D", "d")
            .build();

    map.forEach((k,v) -> System.out.printf ("[%s:%s]", k, v));
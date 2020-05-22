Map<String, String> map = new HashMap<>();
    map.put("a.1", "a1");
    map.put("a.2", "a2");
    map.put("a.3", "a3");
    map.put("b.1", "b1");
    map.put("b.2", "b2");
    map.put("b.3", "b3");
    map.put("c.1", "c1");
    map.put("c.2", "c2");
    map.put("c.3", "c3");

    Map<String, List<String>> grouped = map.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry::getKey))
            .collect(Collectors.groupingBy(
                    entry -> entry.getKey().split("\\.")[0],
                    HashMap::new,
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

    List<SomeObject> objects = grouped.values().stream().map(SomeObject::new).collect(Collectors.toList());

    System.out.println(objects);
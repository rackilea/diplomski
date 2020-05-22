//subjects in order of priority
    List<String> list = Arrays.asList("1021", "1023", "1025", "1027");

    Map<String, List<String>> map = new HashMap<>();
    map.put("1", Arrays.asList("1021","1025", "1027"));
    map.put("2", Arrays.asList("1021", "1025"));
    map.put("3", Arrays.asList("1023", "1025", "1021"));

    //intersect
    Set<String> intersection = map.values().stream().map(HashSet::new)
        .collect(() -> new HashSet<>(list), Set::retainAll, Set::retainAll);

    //find highest priority
    Optional<String> first = list.stream().filter(intersection::contains).findFirst();
    System.out.println("first = " + first.orElse(""));
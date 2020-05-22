Multimap<Integer, String> dataSet = HashMultimap.create();

    dataSet.put(1, "foo");
    dataSet.put(1, "bar");
    dataSet.put(1, "baz");

    // prints [baz, bar, foo]
    System.out.println(dataSet.get(1));
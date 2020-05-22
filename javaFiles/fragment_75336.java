List<Object> list = new ArrayList<>(Collections.nCopies(10_000, ""));
System.out.println(System.getProperty("java.version"));
System.out.println(Runtime.getRuntime().availableProcessors());
System.out.println( list.parallelStream()
    .collect(
        () -> new ArrayList<>(Collections.singleton(0)),
        (l,x) -> l.replaceAll(i -> i + 1),
        List::addAll) );
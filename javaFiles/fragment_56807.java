Stream<String> lines = IntStream.range(1, 20000).mapToObj(i -> i + "");
    System.out.println(lines.isParallel());
    lines = lines.parallel();
    System.out.println(lines.isParallel());

    List<String> collected = lines.collect(oddLines());

    System.out.println(collected.size());
String s = "1-4\n" + "5-6\n" + "1-2\n" + "4-7"; //simpler version with inline text

Optional<Entry<Integer, Long>> result = 
    Stream.of(s.split("\n")) //replace with Files.lines(path) for real stream
    .map(line -> line.split("-"))
    .map(array -> new int[] { Integer.parseInt(array[0].trim()), 
                              Integer.parseInt(array[1].trim()) })
    .map(array -> IntStream.rangeClosed(array[0], array[1]))
    .flatMapToInt(Function.identity())
    .boxed()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet()
    .stream()
    .max(Comparator.comparingLong(Entry::getValue));

result.ifPresent(System.out::println);
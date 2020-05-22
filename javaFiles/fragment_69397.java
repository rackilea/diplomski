public static void main(String[] args) {

    List<String> lines = Arrays.asList("AAA", "BBB", "AAA", "BBB", "CCC", "CCC");

    List<String> result = lines.stream()           // convert list to stream
            .filter(line -> "BBB".equals(line))    // we want to filter all fields like "BBB"
            .collect(Collectors.toList());         // collect the output and convert streams to a List

    result.forEach(System.out::println);           // output : BBB, BBB

}
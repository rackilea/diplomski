public static String sortLists(List<String> firstList, List<String> secondList, List<String> thirdList) {
    List<List<String>> sorted = Stream.of(firstList, secondList, thirdList)
            .sorted(Comparator.comparingInt(List::size))
            .collect(Collectors.toList());
    return "long: " + sorted.get(0) + ", longer: " + sorted.get(1) + ", longest: " + sorted.get(2);
}
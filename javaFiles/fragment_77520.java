private static Map<Character, Long> populateMap(List<Character> chars) {

    return chars.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

}
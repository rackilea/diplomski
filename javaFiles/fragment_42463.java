public static List<String> sortFunctional(List<String> list){

    Comparator<String> firstThree= Comparator.comparing(item -> item.substring(0,3));
    Comparator<String> letter = Comparator.comparing(item -> (!item.endsWith("Letter.pdf")));
    return list.stream()
            .sorted(firstThree.thenComparing(letter))
            .collect(Collectors.toList());
}
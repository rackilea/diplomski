public static void loopingIssue(Integer totalItems, Integer range) {
    IntStream.range(0, totalItems).filter(i -> i % range == 0)
            .mapToObj(e -> mapToGroup(e, totalItems, range))
            .forEach(System.out::print);
}

public static String mapToGroup(Integer e, Integer totalItems, Integer maxRange) {
    if (e + maxRange >= totalItems) {
        return e + "-" + (totalItems - 1);
    } else {
        return e + "-" + (e + maxRange - 1) + ", ";
    }

}
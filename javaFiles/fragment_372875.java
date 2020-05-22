public static double averageList(List<Integer> testList) {
     return testList.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElse(0.0);
}
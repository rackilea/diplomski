List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

double intAverage = testList.stream()
    .mapToInt(Integer::intValue)
    .average()
    .orElse(0.0);

System.out.println(intAverage);
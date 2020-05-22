private static void print(List<Integer> data, 
                      Collector<Integer, ?, ? extends Map<?, List<Integer>>> collector) {
    data.stream().collect(collector)
            .forEach((key, list) -> System.out.println(key + ": " + list));
}

private static void printByMagnitude() {
    List<Integer> data = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    print(data, Collectors.<Integer,String>groupingBy(i -> i < 5 ? "small" : "large"));
}

private static void printByModulus() {
    List<Integer> data = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    print(data, Collectors.<Integer,Integer>groupingBy(i -> i % 2));
}
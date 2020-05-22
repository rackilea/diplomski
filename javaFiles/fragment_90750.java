public static void main(String[] args) {
    List<Integer> list = Arrays.asList(0,12,16,23,66);
    List<String> result = IntStream.range(0, list.size() - 1)
                                   .mapToObj(i -> list.get(i) + "-" + list.get(i+1))
                                   .collect(Collectors.toList());
    System.out.println(result);
}
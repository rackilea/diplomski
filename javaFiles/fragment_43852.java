public static void main(String[] args) {
  List<String> stringList = Arrays.asList("a", "b", "c", "d");
  List<Integer> indices = Arrays.asList(1, 3);

  List<String> resultList = indices.stream()
                  .map(i -> stringList.get(i))
                  .collect(Collectors.toList());

  System.out.println(resultList);
}
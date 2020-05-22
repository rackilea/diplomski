public static void main(String[] args) {
  List<String> stringList = Arrays.asList("a", "b", "c", "d");
  List<Integer> indices = Arrays.asList(1, 3);

  List<String> resultList = new ArrayList<>();

  for(int i : indices) {
    resultList.add(stringList.get(i));
  }

  System.out.println(resultList);  
}
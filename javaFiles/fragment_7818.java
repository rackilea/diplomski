public class TestProgram {
  public static void main(String...args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
    map.put(2, 1);
    map.put(3, 1);
    map.put(4, 2);
    map.put(5, 2);
    map.put(6, 3);

    Map<Object, List<Object>> result = map.entrySet().stream()
        .collect(Collectors.groupingBy(
              Entry::getValue, 
              HashMap::new, 
              Collectors.mapping(Entry::getKey, Collectors.toList())
            ));
    System.out.println(result);
    // {1=[1, 2, 3], 2=[4, 5], 3=[6]}
  }
}
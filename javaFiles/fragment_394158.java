import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Main {

  public static void main(String[] args) {
    final Map<Long, List<String>> map = createTestMap();
    final List<Long> keyList = asList(1L, 3L, 10L);
    final List<String> resultList = keyList.stream()
        .map(map::get)
        .map(ArrayList::new)  // need to create new lists not to corrupt the existing ones
        .reduce((left, right) -> { left.addAll(right); return left;})  // accumulate the list
        .orElse(new ArrayList<>());  // empty list if nothing was found
    System.out.println(resultList);
  }

  private static Map<Long, List<String>> createTestMap() {
    final Map<Long, List<String>> map = new HashMap<>();
    final List<String> oneList = asList("1 love", "1 peace");
    final List<String> threeList = singletonList("3 words");
    final List<String> tenList = emptyList();
    final List<String> ninetyList = singletonList("99 problems");
    map.put(1L, oneList);
    map.put(3L, threeList);
    map.put(10L, tenList);
    map.put(90L, ninetyList);
    return map;
  }
}
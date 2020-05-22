import java.util.*;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) {
    String test = "aaabcccdddd";
    Map<String, Long> hashMap = 
      Arrays.stream(test.split("")).
      collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    // System.out.println(hashMap); // {a=3, b=1, c=3, d=4}
    Map<String, Long> treeMap = new TreeMap(Collections.reverseOrder());
    treeMap.putAll(hashMap);
    // System.out.println(treeMap); // {d=4, c=3, b=1, a=3}
    for (Map.Entry<String, Long> entry : treeMap.entrySet()) {
      for(int i = 0; i < entry.getValue(); i++) {
        System.out.print(entry.getKey());
      }
    }
  }
}
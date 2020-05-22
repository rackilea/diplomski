import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Example
{
  public static void main(String[] args)
  {
    List<List<Object>> list = Arrays.asList(
      Arrays.<Object>asList("A", "X", 1),
      Arrays.<Object>asList("A", "Y", 5),
      Arrays.<Object>asList("B", "X", 1),
      Arrays.<Object>asList("B", "X", 2)
    );

    Map<Set<Object>, List<List<Object>>> groups = list.stream()
    .collect(groupingBy(Example::newGroup));

    System.out.println(groups);

    Map<Set<Object>, Integer> sums = list.stream()
    .collect(groupingBy(Example::newGroup, summingInt(Example::getInt)));

    System.out.println(sums);

    Map<Set<Object>, Optional<List<Object>>> max = list.stream()
    .collect(groupingBy(Example::newGroup, maxBy(Example::compare)));

    System.out.println(max);
  }

  private static Set<Object> newGroup(List<Object> item)
  {
    return new HashSet<>(Arrays.asList(item.get(0), item.get(1)));
  }

  private static Integer getInt(List<Object> items)
  {
    return (Integer)items.get(2);
  }

  private static int compare(List<Object> items1, List<Object> items2)
  {
    return (((Integer)items1.get(2)) - ((Integer)items2.get(2)));
  }
}
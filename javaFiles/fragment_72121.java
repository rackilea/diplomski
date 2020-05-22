import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    Function<List<Object>, Set<Object>> groupBy = new Function<List<Object>, Set<Object>>()
    {
      @Override
      public Set<Object> apply(List<Object> item)
      {
        return new HashSet<>(Arrays.asList(item.get(0), item.get(1)));
      }
    };

    Map<Set<Object>, List<List<Object>>> groups = group(
      list,
      groupBy
    );

    System.out.println(groups);

    Map<Set<Object>, Integer> sums = sum(
      list,
      groupBy,
      new Function<List<Object>, Integer>()
      {
        @Override
        public Integer apply(List<Object> item)
        {
          return (Integer)item.get(2);
        }
      }
    );

    System.out.println(sums);

    Map<Set<Object>, List<Object>> max = max(
      list,
      groupBy,
      new Comparator<List<Object>>()
      {
        @Override
        public int compare(List<Object> items1, List<Object> items2)
        {
          return (((Integer)items1.get(2)) - ((Integer)items2.get(2)));
        }
      }
    );

    System.out.println(max);

  }

  public static <K, V> Map<K, List<V>> group(Collection<V> items, Function<V, K> groupFunction)
  {
    Map<K, List<V>> groupedItems = new HashMap<>();

    for (V item : items)
    {
      K key = groupFunction.apply(item);

      List<V> itemGroup = groupedItems.get(key);
      if (itemGroup == null)
      {
        itemGroup = new ArrayList<>();
        groupedItems.put(key, itemGroup);
      }

      itemGroup.add(item);
    }

    return groupedItems;
  }

  public static <K, V> Map<K, Integer> sum(Collection<V> items, Function<V, K> groupFunction, Function<V, Integer> intGetter)
  {
    Map<K, Integer> sums = new HashMap<>();

    for (V item : items)
    {
      K key = groupFunction.apply(item);
      Integer sum = sums.get(key);

      sums.put(key, sum != null ? sum + intGetter.apply(item) : intGetter.apply(item));
    }

    return sums;
  }

  public static <K, V> Map<K, V> max(Collection<V> items, Function<V, K> groupFunction, Comparator<V> comparator)
  {
    Map<K, V> maximums = new HashMap<>();

    for (V item : items)
    {
      K key = groupFunction.apply(item);
      V maximum = maximums.get(key);

      if (maximum == null || comparator.compare(maximum, item) < 0)
      {
        maximums.put(key, item);
      }
    }

    return maximums;
  }

  private static interface Function<T, R>
  {
    public R apply(T value);
  }
}
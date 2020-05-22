package ex;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class PairCollectors {

  /**
   * A view on a list of its elements as pairs.
   * 
   * @param <T> the element type
   */
  static class PairList<T> extends AbstractList<List<T>> {
    private final List<T> elements;

    /**
     * Creates a new pair list.
     * 
     * @param elements the elements
     * 
     * @throws NullPointerException if elements is null
     * @throws IllegalArgumentException if the length of elements is not even
     */
    public PairList(List<T> elements) {
      Objects.requireNonNull(elements, "elements must not be null");
      this.elements = new ArrayList<>(elements);
      if (this.elements.size() % 2 != 0) {
        throw new IllegalArgumentException("number of elements must have even size");
      }
    }

    @Override
    public List<T> get(int index) {
      return Arrays.asList(elements.get(index), elements.get(index + 1));
    }

    @Override
    public int size() {
      return elements.size() / 2;
    }
  }

  /**
   * Returns a collector that collects to a pair list.
   * 
   * @return the collector
   */
  public static <E> Collector<E, ?, PairList<E>> toPairList() {
    return Collectors.collectingAndThen(Collectors.toList(), PairList::new);
  }

  /**
   * Creates a pair list with collectingAndThen, toList(), and PairList::new
   */
  @Test
  public void example() {
    List<List<Integer>> intPairs = Stream.of(1, 2, 3, 4, 5, 6)
        .collect(toPairList());
    System.out.println(intPairs); // [[1, 2], [2, 3], [3, 4]]

    List<List<String>> stringPairs = Stream.of("a", "b", "c", "d")
        .collect(toPairList());
    System.out.println(stringPairs); // [[a, b], [b, c]]
  }    
}
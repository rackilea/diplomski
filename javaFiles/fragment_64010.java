import java.util.List;
import java.util.Comparator;

class MyComparator implements Comparator<Double> {
  public int compare(Double d1, Double d2) {    // (d1,d2) ->
    return d1.compareTo(d2);                    // d1.compareTo(d2)
  }
}

public class Testing {
    public static void main(String[] args) {
      List<Double> list = List.of(1.1,2.2,3.3,4.4,5.5,6.6,7.7);

      Double maxClass =
        list.stream()
            .max(new MyComparator())
            .orElse(Double.NEGATIVE_INFINITY);

      Double maxLamdba =
        list.stream()
            .max((d1,d2) -> d1.compareTo(d2))
            .orElse(Double.NEGATIVE_INFINITY);

      Double maxMethodreference =
        list.stream()
            .max(Double::compareTo)
            .orElse(Double.NEGATIVE_INFINITY);
   }
}
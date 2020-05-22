import java.util.List;
import java.util.ArrayList;

public class GetExtrema  {

  public static <T extends Comparable<T>> List<T> getExtrema(T[] series) {
    List<T> extrema = new ArrayList<T>();
    extrema.add(series[0]);
    boolean upElseDown = series[1].compareTo(series[0]) > 0;
    for (int i = 2; i < series.length; ++i) {
        if (series[i].compareTo(series[i-1]) > 0 != upElseDown) {
            extrema.add(series[i-1]);
            upElseDown = !upElseDown;
        } // end if
    } // end for
    extrema.add(series[series.length-1]);
    return extrema;
  } // end getExtrema()

  public static void main(String[] args) {

    Integer[] s1 = {20,22,25,27,30,31,30,25,22,19,21,25,28,30,28,27};
    List<Integer> extrema = getExtrema(s1);
    System.out.println(extrema);

    Double[] s2 = {55.2,57.3,54.3,59.2,61.,58.2,55.4,53.5,58.7,60.1,55.1,53.4,50.,51.1,52.};
    List<Double> extrema2 = getExtrema(s2);
    System.out.println(extrema2);

    System.exit(0);

  } // end main()

} // end class GetExtrema
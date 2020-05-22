import java.util.Comparator;

public class SpeedComparator implements Comparator<String> {

  public int compare(String o1, String o2) {

    int indexSeparator1 = o1.indexOf(' ');
    int indexSeparator2 = o2.indexOf(' ');
    String number1 = o1.substring(0, indexSeparator1);
    String number2 = o2.substring(0, indexSeparator2);

    double value1 = Double.valueOf(number1);
    double value2 = Double.valueOf(number2);

    String measure1 = o1.substring(indexSeparator1 + 1, o1.length());
    String measure2 = o2.substring(indexSeparator2 + 1, o2.length());

    value1 = getRealValue(value1, measure1);
    value2 = getRealValue(value2, measure2);

    return (int) (value1 - value2);

  }

  private double getRealValue(double value, String measure) {
    switch (Measure.valueOf(measure.toUpperCase())) {
      case BPS:
        return value;
      case KBPS:
        return value * 1000;
      case MBPS:
        return value * 1000000;
      case GBPS:
        return value * 1000000000;
    }
    return value;
  }

  enum Measure {
    BPS, KBPS, MBPS, GBPS
  }
}
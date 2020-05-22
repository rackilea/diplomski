public class NameComparator implements Comparator {

  static private [] String strNames = {"Ken", "Alisia", "Ben"};

  public int compare(MyClass objX, MyClass objY) {
    String x = objX.Name;
    String y = objY.Name;
    String strCurrentName;

    if(x.equals(y)) {
      return 0;
    }

    for(strCurrentName: strNames) {
      if(strCurrentName.equals(x)) {
        return 1;
      }
      if(strCurrentName.equals(y)) {
        return -1;
      }
    }
    return x.compareTo(y);
  }

}
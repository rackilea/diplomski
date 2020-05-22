public class MyComparator implements Comparator<MyObject> {    
  public int compare(MyObject o1, MyObject o2) {
    if (o1 == null || o2 == null) {
      throw new NullPointerException();
    }    
    if (o1.getValue1() != o2.getValue1()) {
      return Integer.compare(o1.getValue1(), o2.getValue1());
    }    
    return Integer.compare(o1.getValue2(), o2.getValue2());
  }
}
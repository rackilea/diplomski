public class Factory {

  private Factory() {}

  public static Writer createWriter(Object o) {
    Writer result = null;
    if (o.getClass() == MyObject1.class) {
       result = new MyFirstObjectWriter();
    } else if (...) {
       ...
    } else {
       throw new IllegalArgumentException("Unsupported object class" + o.getClass());
    }
    return result;
  }
}
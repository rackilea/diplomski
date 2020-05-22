public class ArrayCount {
  private int   count = 0;
  private Array a;

  public ArrayCount(Array a) {
    this.a = a;
  }

  public void add(Object element) {
    a.add(element);
    ++count;
  }

  public void addAll(Object elements[]) {
    a.addAll(elements);
    count += elments.length;
  }

}
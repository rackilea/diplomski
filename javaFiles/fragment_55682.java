public class MyArrayList<E> extends MyAbstractList<E> {
  public static final int INITIAL_CAPACITY = 16;
  private E[] data = (E[])new Object[INITIAL_CAPACITY];

  public MyArrayList(E[] objects) {
     super(objects); // this call to super() executes before data is initialized
  }
}
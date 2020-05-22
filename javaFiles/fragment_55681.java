public abstract class MyAbstractList<E> {
  protected int size = 0; // The size of the list

  protected MyAbstractList() {}

  protected MyAbstractList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
}
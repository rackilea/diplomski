public class MyCollection<T> {
  private T element;
  private T[] array;

  MyCollection(){
     array = (T[]) Array.newInstance( Comparable.class , 0); 
  }

  public void set(T element) {
     this.element = element;
  }

  public T get() {
    return element;
  }

  public void insert(T i) {


     T[] temp = (T[])  Array.newInstance(array.getClass().getComponentType(), array.length + 1);
     temp[array.length] = i;
     System.arraycopy(array, 0, temp, 0, array.length);
     array = temp;
  }

}
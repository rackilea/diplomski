public interface UnmodifiableList<T> {
     public T get(int pos);
     ....
 }

 public interface List<T> extends UnmodifiableList<T> {
     public void add(T elem);
     ....
 }
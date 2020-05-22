public interface List <T> {
     public T get(int pos);
     public void add(T elem);
     ....
 }

 public interface UnmodifiableList<T> {
     // A marker interface
 }
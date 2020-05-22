public interface Foo<T> {
    public void bar(T[] list);
}

public class FooImpl<T extends Comparable<? super T>> implements Foo<T> {
   @Override
   public void bar(T[] list) {
       ...
   }
}
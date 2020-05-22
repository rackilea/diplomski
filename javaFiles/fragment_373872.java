public interface A {
    Collection<? extends A> doSomething();
}

public interface B extends A{
    Collection<B> doSomething(); 
}
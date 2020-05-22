public class X<T>{
public void someMethod(T t) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    t.getClass().getMethod("getProp", null).invoke(t, null);
}
public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    X<A> weird = new X<>();
    A a = new A();
    weird.someMethod(a);
}
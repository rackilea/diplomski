public class Demo {
public static void main(String[] args) {
    Class foo = Foo.class;
    Class[] declaredClasses = foo.getDeclaredClasses();
    for (Class class1 : declaredClasses) {
        System.out.println(Modifier.isStatic(class1.getModifiers()));
    }
}
}

class Foo {
    static class A {}
    class B {}
    static class C {}
}
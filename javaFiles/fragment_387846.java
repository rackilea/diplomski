public class Test {    
    public static void main(String[] args) {
        new Foo<String>().printComponentType();
    }
}

class Foo<T> {
    public void printComponentType() {
        System.out.println(getClass().getComponentType()); // null
    }
}
public class Parent {
    public Parent() { // I could have left this off, since it's the default for a
    }                 // base class; it's here for emphasis
    public static void main(String[] args) {
        new Child();
    }
}

class Child extends Parent {
}
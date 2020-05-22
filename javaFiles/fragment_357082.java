class Parent {
    public String string = "parent";
    public int getInt() {
        return 1;
    }
}

class Child extends Parent {
    public String string = "child"; // does not override Parent.string
    // overrides Parent.getInt():
    public int getInt() {
        return 2;
    }
}

public class Main {
    public static void main(final String... args) {
        Child child = new Child();
        System.out.println(child.string);            // prints "child"
        System.out.println(child.getInt());          // prints "2"
        Parent childAsParent = child;
        System.out.println(childAsParent.string);    // prints "parent" (no override)
        System.out.println(childAsParent.getInt());  // prints "2" (yes override)
    }
}
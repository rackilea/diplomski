public interface InterfaceA {
    public static void staticInterfaceMethod() {
        ...
    }
}

public interface InterfaceB {
    public static void staticInterfaceMethod() {
        ...
    }
}

public class ClassAB implements InterfaceA, InterfaceB {
    ...
}
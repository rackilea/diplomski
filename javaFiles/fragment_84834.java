public class SubClass extends ImplementingSubClass {...}

public class AnotherClass {
    private ImplementingSubClass sc;
    public AnotherClass(ImplementingSubClass superclass) {
        sc = superclass;
    }
    ...
}
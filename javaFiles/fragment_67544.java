public class Root {
    private Set<Foo> foos;
    // ... getter and setter
}

public class Foo {
    Map<String, InternalFooProps> map = new HashMap<>();    
    class InternalFooProps{
        private String prop1;
        private String prop2;
        // ... getters and setters
    }
}
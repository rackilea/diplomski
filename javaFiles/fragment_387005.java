public class Foo {
    private Long id;
    private String text;
    private Set<Bar> bars = new HashSet<Bar>();    
    // constructors, getters, setters
}

public class Bar {
    private Long id;
    private boolean deleted;
    private String text;
    // constructors, getters, setters
}
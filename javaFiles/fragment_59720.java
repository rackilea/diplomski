public class A {
    public String field;
    @JsonUnwrapped
    public B b;
}

public class B {
    public int n;
}
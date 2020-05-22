class A {
    @JsonProperty
    int some = 1;

    @JsonUnwrapped
    B anotherObject = new B();
}

class B {
    @JsonProperty
    int someB = 2;
}
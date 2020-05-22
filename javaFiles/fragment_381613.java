class A {
    @Autowired 
    SomeType one;
    String two;
    int three;

    public A() {
        this.two = one.someMethod();
    }
}
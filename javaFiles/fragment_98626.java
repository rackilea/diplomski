public class Foo {
    @Autowired
    private MyConfig myConfig;

    public void someMethod() {
        doSomething(myConfig.getIdentifier());
    }
}
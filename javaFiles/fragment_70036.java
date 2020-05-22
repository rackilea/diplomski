public class MyClass implements InitializingBean {

    static { ... } // static initializer
    { ... }  // non-static initializer

    public void afterPropertiesSet() throws Exception { ... }
}
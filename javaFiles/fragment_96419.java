public class A {

    @Autowired
    private class B b;

    public A{
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); 
    }

}
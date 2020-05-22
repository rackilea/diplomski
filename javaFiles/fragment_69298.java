@Component
public class MyOtherBean {
    @Autowired
    private ApplicationContext applicationContext;

    public void someMethod() {
        //I can use the ApplicationContext here.
    }
}
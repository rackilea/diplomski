public class SomeClass implements ApplicationContextAware {
    //your class definition
    private ApplicationContext myContext;

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        myContext = context;
        //load beans here maybe?
    }
}
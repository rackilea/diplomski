@Component
public class ExampleClass implements ApplicationContextAware {
    /* 
     * The ApplicationContextAware interface is a special interface that allows 
     * a class to hook into Spring's Application Context. It should not be used all
     * over the place, because Spring provides better ways to get at your beans
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyBean bean = applicationContext.getBean("MyBean");
    }
}
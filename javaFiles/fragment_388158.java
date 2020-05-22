@Component(value="someBean")
public class SomeBean {

    @PreDestroy
    public void destroy() {
        System.out.println("Im inside destroy...");
    }
}
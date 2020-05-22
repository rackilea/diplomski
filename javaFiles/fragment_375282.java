@Component
public class Test {

    private final Parent parent;

    public Test(ApplicationContext applicationContext) {
        this.parent = applicationContext.getBean("anotherContext", ApplicationContext.class).getBean("child", Parent.class);
    }
}
@SpringBootApplication
public class Controller {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Controller.class, args);
        Test test = ctx.getBean(Test.class);
        test.doWork();
    }
}
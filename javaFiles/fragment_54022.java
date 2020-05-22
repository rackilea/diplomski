@EnableAspectJAutoProxy
@ComponentScan
@Configuration
public class PrintMain {

    public static void main(String[] args) {
        // Do I always need to have this. Can't I just use @Autowired to get beans
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TNGPrintMain.class);
        CheckService ck = (CheckService)ctx.getBean("service");
        ck.print();
    }

    @Bean(name="service")
    public CheckService service(){
        return new CheckService();
    }

}
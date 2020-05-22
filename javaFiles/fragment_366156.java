@SpringBootApplication
@EnableAspectJAutoProxy
public class AopExampleApp implements CommandLineRunner {

    @Autowired
    ExceptionalService service;

    @Override
    public void run(String... args) throws Exception {
        try {
            service.thorowException();
            thorowException();
        } catch (Exception ex) {
            // Do nothing Since aop will log the answer
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApp.class);
    }

    public static void thorowException() throws Exception {
        throw new Exception();
    }
}
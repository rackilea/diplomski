@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private MyService myService;

    @Override
    public void run(String...args) throws Exception {
       myService.save();

    }
}
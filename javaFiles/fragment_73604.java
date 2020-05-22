@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ConnectService connectionService;

    @Override
    public void run(String... args) {

        String output = connectionService.connect();
        CurrencyData currencyData = connectionService.gsonCurrency(output);
        currencyRepository.save(currencyData);

    } 
}
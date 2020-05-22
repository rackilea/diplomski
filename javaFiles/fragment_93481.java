@SpringBootApplication
public class ApppropApplication {

    @Autowired
    private AppConfig appConfig;

    public static void main(String[] args) {
        SpringApplication.run(ApppropApplication.class, args);
    }

    @PostConstruct
    public void init(){
        System.out.println(appConfig.getTestProperty());
    }
}
@SpringBootApplication
public class DataLoadersApplication implements CommandLineRunner {
    public interface LoadProcess {
        void doLoad();
    }

    @Component // default that exists unconditionally in any profile
    static class Type1LoadProcess implements LoadProcess {
        @Override public void doLoad() { System.out.println("Load1"); }
    }

    @Profile("type2") // this only exists in the type2 profile
    @Primary          // if it exists it gets picked over others
    @Component
    static class Type2LoadProcess implements LoadProcess {
        @Override public void doLoad() { System.out.println("Load2"); }
    }
    // need a 3rd? @Profile("type3") @Primary @Component

    @Autowired  // need one of them here
    private LoadProcess loadProcess;

    @Override
    public void run(String... args) {
        loadProcess.doLoad();
    }

    public static void main(String[] args) {
        SpringApplication.run(DataLoadersApplication.class, args);
    }
}
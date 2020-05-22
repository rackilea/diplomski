@Service
class ServiceTest(){

    @Value("${fname}")
    private String fname;

    public String printTest(){
        sysout(fname);           // Prints fname value
        // Calling new here means Spring does nothing
        // ModelTest is not a Spring bean
        // `@Component`, `@PostConstruct` and `@Value` in ModelTest mean nothing.
        return new ModelTest().toString() // Prints null
    }
}
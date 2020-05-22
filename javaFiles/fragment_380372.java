@Service
class ServiceTest(){

    @Value("${fname}")
    private String fname;

    @Autowired
    private ModelTest modelTest;

    public String printTest(){
        sysout(fname);           // Prints fname value
        // modelTest is now a Spring bean
        return modelTest.toString() // Should not print null
    }
}
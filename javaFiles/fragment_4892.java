public class PilContainerApplication {

    @Autowired
    MyTestClass myTestClass;


    @PostConstruct
    public void init(){
        myTestClass.transferHello();            
    }

    public static void main(String[] args) {
        SpringApplication.run(PilContainerApplication.class, args);
    }    
}
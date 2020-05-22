@Configuration
public class RabbitConfiguration {

    private List<String> routingKeys ;
    private MyService myService;

    @Autowired
    public RabbitConfiguration(MyService myService){
        this.myService = myService
        this.routingKeys = writeRoutingKeys();
    }

    private List<String> writeRoutingKeys() {
        return myService.getRoutingKeys(); 
    }
 }
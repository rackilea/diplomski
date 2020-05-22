@Component
public class SchedulerBootstrap {

    @Autowired
    MyRepository myRepository;

    @Autowired
    OpenPropertyPlaceholderConfigurer configurer;

    @PostConstruct
    /**
     * This method will be called after the bean has been 
     * instantiated and all dependencies injected.
     */
    public void init() {

    }
}
@Component
public class SomeBean {

    private ParameterRepository parameterRepository; // it is a spring data repository

    private GenericWebApplicationContext context;

    @Autowired
    public void setParameterRepository(ParameterRepository parameterRepository, GenericWebApplicationContext context) {
        this.parameterRepository= parameterRepository;
        this.context = context
    }

    @PostConstruct
    public void someMethod() {
        //query db with parameterRepository and decide
        //context.registerBeanDefinition(...)
    }
}
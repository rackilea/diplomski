@Component
public class XYZService
{
    private C c;

    @Autowired
    private A a;

    public XYZService()
    {
        // Move the initialization to @PostConstruct
    }    

    @PostConstruct
    private void init() {
        this.c = a.doSomething("Hello world");
    }
}
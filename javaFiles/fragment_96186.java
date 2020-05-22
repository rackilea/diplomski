// service with functionality common for all users
@Service
class CommonService implements ICommonService
{
    // because of @Primary an instance of CustomServiceProxy will be injected
    @Autowired
    private ICustomService customServiceImpl;

    @Override
    public void doSomeAction(String param)
    {
        ... do some common stuff

        customResult = customServiceImpl.calculate(param);

        ... do some common stuff with custom result
    }
}

// custom service implementations
@Service
@Primary
class CustomServiceProxy implements ICustomService
{
    private CustomData sessionData;
    private Map<String, ICustomService> services;

    @Autowired
    public CustomServiceProxy(CustomData sessionData, Map<String, ICustomService> services)
    {
        this.sessionData = sessionData;
        this.services = services;
    }

    @Override
    public String calculate(String value)
    {
        String serviceName = "CustomService" + sessionData.getLanguage().toUpperCase();
        ICustomService customService = services.get(serviceName);
        // handle missing service: throw exception or maybe switch to a default implementation
        Objects.requireNonNull(customService, "missing CustomService with name " + serviceName);
        return customService.calculate(value);
    }
}

@Service("CustomServiceUK")
class CustomServiceUK implements ICustomService
{
    @Override
    public String calculate(String value)
    {
        ... execute logic on value for an "uk" user
    }
}

@Service("CustomServiceDE")
class CustomServiceDE implements ICustomService
{
    @Override
    public String calculate(String value)
    {
        ... execute logic on value for an "de" user
    }
}
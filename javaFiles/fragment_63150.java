@Component
public class MyDataFetcher implements DataFetcher, ApplicationContextAware {

    private static MyService myService;
    private static ApplicationContext context;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        return myService.getData();
    }

    @override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansExcepion {
        context = applicationContext;
        myService = context.getBean(MyService.class);
    }
}
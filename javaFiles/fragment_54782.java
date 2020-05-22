@Component
public class AppContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private final AppContext appContext;

    @Autowired
    public AppContextListener(AppContext appContext) {
        this.appContext=appContext;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {       
        // Do your thing with appContext
    }
}
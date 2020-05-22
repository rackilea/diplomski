@Configuration
public class ReloadLookupEvent implements ApplicationListener<RefreshScopeRefreshedEvent> {
    @Autowired
    private CacheService cacheService;

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent event) {
        cacheService.refreshLookUp();          // The target load 
    }

}
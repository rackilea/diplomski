@Component
public class DoOnStart{

    @Autowired
    private IYourService service;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent e) {
        // your CODE
    }

}
public class Bean {

    private Entity entity;

    @EJB
    private EntityService entityService;

    @PostConstruct
    public void init() {
        entity = entityService.find(someId);
    }

    // ...
}
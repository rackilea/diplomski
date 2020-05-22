@Component // Or CDI @Named or JSF @ManagedBean
public class Controller {

    private Entity entity;

    @AutoWired // Or CDI @Inject or JSF @EJB
    private EntityService service;

    @PostConstruct
    public void init() {
        entity = new Entity(); // In case "new entry" is required.
    }

    public void save() {
        service.save(entity);
    }

    public Entity getEntity() { // No setter required.
        return entity;
    }

}
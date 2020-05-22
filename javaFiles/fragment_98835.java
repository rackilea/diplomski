public class Bean {

    private Long id;
    private Entity entity;

    @EJB
    private EntityService service;

    @PostConstruct
    public void init() {
        entity = service.find(id);
    }

    public void save() {
        service.save(entity);
    }

    // Getter/setter for id and getter for entity.
}
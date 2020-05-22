@Component
public class IdentifierCleaner implements PreInsertEventListener {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    private void init() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(this);
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        Object entity = event.getEntity();
        event.getSession().getActionQueue().registerProcess(((success, session) -> {
            if (!success) {
                event.getPersister().resetIdentifier(
                        entity,
                        event.getId(),
                        event.getPersister().getVersion(entity),
                        event.getSession()
                );
            }
        }));
        return false;
    }
}
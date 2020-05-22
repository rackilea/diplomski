@Component
public class TempFactory {
    private final Map<Class, AbstractClass> impletationMap = new HashMap<>();

    @Autowired
    ApplicationContext context;

    public Map<Class, AbstractClass> getImpletationMap() {
        return impletationMap;
    }

    @PostConstruct
    public void initialize() {
        populateDataMapperMap(context.getBeansOfType(AbstractClass.class).values().iterator());
    }

    private void populateDataMapperMap(final Iterator<AbstractClass> classIterator) {
        while (classIterator.hasNext()) {
            AbstractClass abstractClassImpl = classIterator.next();
            impletationMap.put(abstractClassImpl.getClass(), abstractClassImpl);
        }
    }

}
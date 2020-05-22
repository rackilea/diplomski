/**
 * Created on 2015-10-25.
 */
public class ImplementationResolver<T> implements ApplicationContextAware {

    private Class<T> toBeImplemented;


    private Map<String, T> implementations;


    private Map<Class, T> implemenationMapper;


    public ImplementationResolver(Class<T> toBeImplemented) {
        this.toBeImplemented = toBeImplemented;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        implementations = applicationContext.getBeansOfType(toBeImplemented);
    }

    @PostConstruct
    public void intializeMapper() {
        implemenationMapper = new HashMap<Class, T>();
        for (String beanName : implementations.keySet()) {
            T impl = implementations.get(beanName);

            Class<?>[] typeArgs = TypeResolver.resolveRawArguments(toBeImplemented, impl.getClass());

            implemenationMapper.put(typeArgs[0], impl);
        }
    }

    public T getImplementaion(Object whatImplementationIsDoneForMe) {
        return implemenationMapper.get(whatImplementationIsDoneForMe.getClass());
    }
}
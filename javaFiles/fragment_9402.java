public class AnnotationServiceLocator implements ServiceLocator {

    @Autowired
    private ApplicationContext context;
    private Map<String, Service> services;

    public Service getService(String id) {
        checkServices();
        return services.get(id);
    }

    private void checkServices() {
        if (services == null) {
            services = new HashMap<String, Service>();
            Map<String, Object> beans = context.getBeansWithAnnotation(ExampleAnnotation.class);
            for (Object bean : beans.values()) {
                ExampleAnnotation ann = bean.getClass().getAnnotation(ExampleAnnotation.class);
                services.put(ann.value(), (Service) bean);
            }
        }
    }   
}
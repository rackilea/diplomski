@Service
public class MainClassFinder {

    @Autowired
    private ApplicationContext context;

    public String findBootClass() {
        Map<String, Object> annotatedBeans = context.getBeansWithAnnotation(SpringBootApplication.class);
        return annotatedBeans.isEmpty() ? null : annotatedBeans.values().toArray()[0].getClass().getName();
    }
}
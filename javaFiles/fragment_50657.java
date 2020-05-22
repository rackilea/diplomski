@Configuration
@ComponentScan
public class Example {

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        // can also add it here
        //configurer.setPropertySources(propertySources);
        return configurer;
    }

    public static void main(String[] args) {
        Map<String, Object> propertyMap = new HashMap<>();
        propertyMap.put("key.in.map", "value.in.map");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        MapPropertySource propertySource = new MapPropertySource("map-source", propertyMap);
        ctx.getEnvironment().getPropertySources().addLast(propertySource);
        ctx.register(Example.class);
        ctx.refresh();

        MyClass instance = ctx.getBean(MyClass.class);
        System.out.println(instance.getMyValue());
    }
}

@Component
class MyClass {
    private String myValue;
    @Autowired
    public MyClass(@Value("${key.in.map}") String myValue) {
        this.myValue = myValue;
    }
    public String getMyValue() {
        return myValue;
    }
}
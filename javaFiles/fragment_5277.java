@Component
public class MyLoader {
    private Properties keys;

    @PostConstruct
    public void init() throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("app.properties"));
        bean.afterPropertiesSet();
        keys = bean.getObject();
    }
}
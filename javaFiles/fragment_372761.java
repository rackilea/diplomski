@Component
@ConfigurationProperties(locations = "classpath:config/hibernate.properties", prefix = "hibernate")
public class HibernateProperties {

    Properties datasource = new Properties();

    public Properties getDatasource() {
        return datasource;
    }

}
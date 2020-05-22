@Configuration
public class DataSourceConfig {

    ... // some common methods to both @Dev & @Prod

    @Configuration
    @Dev
    public static class DataSourceDev implements DataSourceSetup {

        @Bean
        @Override
        public DataSource dataSource {
            ...
        }

        @Bean
        @Override
        public LocalSessionFactoryBean sessionFactory() {
            ...
        }

        ...

    }

    @Configuration
    @Prod
    public static classs DataSourceProd implements ... {
        ...
    }

    ...

}
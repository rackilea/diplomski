import com.mchange.v2.c3p0.ComboPooledDataSource

@Component
public DataSourceInitializer implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       ComboPooledDataSource dataSource = event.getApplicationContext().getBean("dataSource", ComboPooledDataSource.class);
       dataSource.getConnection().close();
    }
}
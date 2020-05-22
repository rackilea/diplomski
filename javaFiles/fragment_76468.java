@ConfigurationProperties(prefix = "ds")
public class DataSourceSettings implements BeanFactoryAware {

    private List<String> clients = new ArrayList<>();

    private BeanFactory beanFactory;

    public List<String> getClients() {
        return clients;
    }

    public void setClients(List<String> clients) {
        this.clients = clients;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @PostConstruct
    public void configure() {
        Map<String, String> clientDataSources = new HashMap<String, String>();
        for (String client : clients) {
            // extract client name
            String[] parts = client.split("\\|");
            String clientName = parts[0];
            String url = parts[1];
            // client to datasource mapping
            String dsName = url.substring(url.lastIndexOf("/") + 1);
            if (clientName.contains(",")) {
                // multiple clients with same datasource
                String[] clientList = clientName.split(",");
                for (String c : clientList) {
                    clientDataSources.put(c, url);
                }
            }
            else {
                 clientDataSources.put(clientName, url);
            }
        }
        Assert.state(beanFactory instanceof ConfigurableBeanFactory, "wrong bean factory type");
        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
        for (Map.Entry<String, String> entry : clientDataSources.entrySet()) {
            DataSource dataSource = createDataSource(entry.getValue());
            configurableBeanFactory.registerSingleton(entry.getKey(), dataSource);
        }
    }

    private DataSource createDataSource(String url) {
        return DataSourceBuilder.create().url(url).build();
    }
}
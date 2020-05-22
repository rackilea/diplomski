public class EmbeddedElasticsearchServer implements InitializingBean {

    public EmbeddedElasticsearchServer() {

        ImmutableSettings.Builder elasticsearchSettings = ImmutableSettings.settingsBuilder()
                .put("http.enabled", "false")
                .put("path.data", "target/elasticsearch-data");

        node = nodeBuilder()
                .local(true)
                .settings(elasticsearchSettings.build())
                .node();

        client = node.client();


    }

    @Override
    public void afterPropertiesSet() throws Exception {
         // Initialization stuff:
         // - create required indices
         // - define mappings
         // - populate with test data
    }

    public Client getClient() {
         return client;
    }

}
public abstract class Mapper<T extends UserDefinedResponse> {

    private static final Map<Class<T>, Map<String, Mapper<T>>> MAPPERS = new HashMap<>();

    static {
        // Mappers for Products
        Map<String, Mapper<Product>> productMappers = new HashMap<>();
        productMappers.put("CLIENT_1", new ProductMapperClient1());
        productMappers.put("CLIENT_2", new ProductMapperClient2());
        // etc for rest of clients
        MAPPERS.put(Product.class, productMappers);

        // Mappers for Providers
        Map<String, Mapper<Provider>> providerMappers = new HashMap<>();
        providerMappers.put("CLIENT_1", new ProviderMapperClient1());
        providerMappers.put("CLIENT_2", new ProviderMapperClient2());
        // etc for rest of clients
        MAPPERS.put(Provider.class, providerMappers);

        // etc for rest of entities 
        // (each entity needs to add specific mappers for every client)
    }

    protected Mapper() {
    }

    public static void fillDynamicProperties(T response, Map<String, Object> dynamicProperties) {
        // Get mapper for entity and client
        Mapper<T> mapper = MAPPERS.get(response.getClass()).get(response.clientId);
        // Perform entity -> map mapping
        mapper.mapFromEntity(response, dynamicProperties);
    }

    public static void setDynamicProperty(Map<String, Object> dynamicProperties, String name, T response) {
        // Get mapper for entity and client
        Mapper<T> mapper = MAPPERS.get(response.getClass()).get(response.clientId);
        // Perform map -> entity mapping
        mapper.mapToEntity(dynamicProperties, name, response);
    }

    protected abstract void mapFromEntity(T response, Map<String, Object> dynamicProperties);

    protected abstract void mapToEntity(Map<String, Object> dynamicProperties, String name, T response);
}
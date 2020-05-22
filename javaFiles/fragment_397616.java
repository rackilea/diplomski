interface PropertyExtractor<Data> {
    Object extract(Data data);
}

abstract class PropertyResolverChain<Data> implements PropertyResolver {
    private final Map<String, PropertyExtractor<Data>> extractors = new HashMap<>();
    private final PropertyResolver successor;

    protected PropertyResolverChain(PropertyResolver successor) {
        this.successor = successor;
    }

    protected abstract Data getData();

    protected final void setBinding(String property, PropertyExtractor<Data> extractor) {
        extractors.put(property, extractor);
    }

    @Override
    public Map<String, Object> resolve(List<String> properties) {
        ...
    }
}
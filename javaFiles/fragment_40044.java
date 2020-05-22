@Singleton
class StringProcessorWrapper {

    private final Map<String, Processor> processorMap;
    private final Processor defaultProcessor;

    @Inject
    public StringProcessorWrapper(Map<String, Processor> processorMap, @Named("default") Processor defaultProcessor) {
        this.processorMap = processorMap;
        this.defaultProcessor = defaultProcessor;
    }

    public Processor get(String key) {
        return processorMap.getOrDefault(key, defaultProcessor);
    }
}
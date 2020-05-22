public class TrackingImportXmlApplicationContext extends ClassPathXmlApplicationContext {

    private static final TrackingImportReaderEventListener trackingImportReaderEventListener = new TrackingImportReaderEventListener();

    public TrackingImportXmlApplicationContext(String configLocation) {
        super(configLocation);
    }

    public TrackingImportXmlApplicationContext(String... configLocations) {
        super(configLocations);
    }

    @Override
    protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
        super.initBeanDefinitionReader(reader);
        reader.setEventListener(trackingImportReaderEventListener);
    }

    public TrackingImportReaderEventListener getTrackingImportReaderEventListener() {
        return trackingImportReaderEventListener;
    }

    public static class TrackingImportReaderEventListener extends EmptyReaderEventListener {

        private final Set<String> imports = new HashSet<>();

        @Override
        public void importProcessed(ImportDefinition importDefinition) {
            imports.add(importDefinition.getImportedResource());
        }

        public Set<String> getImports() {
            return imports;
        }
    }
}
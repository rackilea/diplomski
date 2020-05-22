class SomeProcessor implements Processor<String, String> {

    private KeyValueStore<String, String> refDataStore;
    private ProcessorContext processorContext;

    @Override
    public void init(final ProcessorContext context) {
        refDataStore = (KeyValueStore) context.getStateStore("ref-data-store");
        processorContext = context;
    }

    @Override
    public void process(String key String value) {
        Object refData = refDataStore.get("some_key");

        // business logic here

        if(ok) {
           processorContext.forward(key, value, To.child("success"));
        } else {
           processorContext.forward(key, value, To.child("error"));
        }
    }
}
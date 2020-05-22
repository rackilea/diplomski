public class ThreadLocalItemProcessor implements ItemProcessor {

    private ThreadLocal<ItemProcessor> threadProcessor = ThreadLocal.withInitial(() -> new MyProcessor());

    @Override
    public Object process(Object item) throws Exception {
        return threadProcessor.get().process(item);
    }
}
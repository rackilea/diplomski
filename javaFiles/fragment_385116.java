@Singleton
public class MyHandlerCache implements HandlerCache {

    private final Map<String, DeadboltHandler> handlers = new HashMap<>();

    public MyHandlerCache() {
        handlers.put(ConfigKeys.DEFAULT_HANDLER_KEY, new MyDeadboltHandler());
    }

    @Override
    public DeadboltHandler apply(final String key) {
        return handlers.get(key);
    }

    @Override
    public DeadboltHandler get() {
        return handlers.get(ConfigKeys.DEFAULT_HANDLER_KEY);
    }
}
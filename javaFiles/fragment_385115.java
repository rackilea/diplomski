@Singleton
public class MyHandlerCache implements HandlerCache {

    private final Map<String, DeadboltHandler> handlers = new HashMap<>();

    public MyHandlerCache() {
        handlers.put("DEFAULT_KEY", new MyDeadboltHandler());
    }

    @Override
    public DeadboltHandler apply(final String key) {
        return handlers.get(key);
    }

    @Override
    public DeadboltHandler get() {
        return handlers.get("DEFAULT_KEY");
    }
}
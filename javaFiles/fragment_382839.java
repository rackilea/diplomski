private static final Map<String, Handler> nameToHandler = new HashMap<>();

static {
    nameToHandler.put("Foo", new FooHandler());
    nameToHandler.put("Bar", new BarHandler());
}
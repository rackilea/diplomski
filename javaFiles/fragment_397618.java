class FooBarResolver extends PropertyResolverChain<FooBarData> {
    private final FooBarService remoteService;

    FooBarResolver(PropertyResolver successor, FooBarService remoteService) {
        super(successor);
        this.remoteService = remoteService;

        // return the whole object
        setBinding("foobar", data -> data);

        // accept different spellings
        setBinding("foo", data -> data.getFoo());
        setBinding("bar", data -> data.getBar());
        setBinding("FOO", data -> data.getFoo());
        setBinding("__bar", data -> data.getBar());

        // create new properties all together!!
        setBinding("barfoo", data -> data.getBar() + data.getFoo());
    }

    @Override
    protected FooBarData getData() {
        return remoteService.invoke();
    }
}
abstract class Foo {

    @Autowired
    CompletionService parserService;

    protected abstract ParseThread createThread();

    public void parse(List<MyObjInt> objs) {
        for (final AsupStoreObj obj : objs) {
            ParseThread t = createThread();
            t.setObject(obj);
            parserService.submit(t);
        }
    }
}
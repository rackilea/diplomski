private Context context;

@Rule
public ExternalResource resource= new ExternalResource() {
    @Override
    protected void before() throws Throwable {
        // get context from Suite class
        context = MySuite.getContext();
    };

    @Override
    protected void after() {
        // put context into Suite class
        MySuite.setContext(context);
    };
};
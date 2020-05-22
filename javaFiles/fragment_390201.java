public class SomeController extends Controller {
    private final SomeObject someObject;

    @Inject
    public SomeController(final SomeObject someObject) {
        this.someObject = someObject;
    }

    public Promise<Result> getSomeData() {
        return handleRequest(() -> new SomeDataAjaxRequest(someObject));
    }

    public Promise<Result> handleRequest(Function0<AbstractAjaxRequest<?>> supplier) {
        return Promise.promise(supplier)
                      .map(arg -> ok(arg.getResponse()));
    }
}
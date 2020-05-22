public class MyServlet extends AbstractServlet {

    private final IValidator validator;

    @Inject
    public MyServlet(final IValidator validator) {
        this.validator = validator;
    }

    //... there's more code here (look above) ...
}
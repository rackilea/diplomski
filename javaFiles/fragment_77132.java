public class LaissezFaireInterceptor implements MethodInterceptor {

    private final IValidator validator;

    //... a bunch of other code goes here (see above) ...

    @Inject
    public void setValidator(final LaissezFaireValidator validator) {
        this.validator = validator;
    }

    //... and a bunch more code goes here (again, see above) ...
}
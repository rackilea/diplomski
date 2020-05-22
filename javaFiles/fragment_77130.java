public class ValidatorModule implements Module {
    @Override
    protected void configure() {
        //in the default case, inject an instance of StrictValidator
        bind(IValiator.class).to(StrictValidator.class);
    }
}
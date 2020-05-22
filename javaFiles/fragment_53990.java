public class CustomRunner extends BlockJUnit4ClassRunner {
    public CustomRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Statement withAfterClasses(Statement statement) {
        List<FrameworkMethod> afters = getTestClass().getAnnotatedMethods(AfterClass.class);
        statement = new CustomRunAfters(statement, afters, null);
        return statement;
    }
}
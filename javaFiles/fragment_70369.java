public static class RunnerFactory implements ParametersRunnerFactory {
    @Override
    public org.junit.runner.Runner createRunnerForTestWithParameters(TestWithParameters test) throws InitializationError {
        return new CustomRunnerWithParameters(test);
    }

}

public static class CustomRunnerWithParameters extends BlockJUnit4ClassRunnerWithParameters {
    private final Object[] parameters;

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> tests = new ArrayList<FrameworkMethod>(super.computeTestMethods());
        Collections.shuffle(tests);
        return tests;
    }

    public CustomRunnerWithParameters(TestWithParameters test) throws InitializationError {
        super(test);
        parameters = test.getParameters().toArray(new Object[test.getParameters().size()]);
    }

    @Override
    public Object createTest() throws Exception {
        return getTestClass().getOnlyConstructor().newInstance(parameters);
    }
}
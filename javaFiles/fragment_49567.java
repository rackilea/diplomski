public static class UnstableTestInjector implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod == null) {
            return;
        }

        UnstableTest unstableTest = testMethod.getAnnotation(UnstableTest.class);
        if (unstableTest == null) {
            return;
        }
        annotation.setRetryAnalyzer(TryAgain.class);
    }
}
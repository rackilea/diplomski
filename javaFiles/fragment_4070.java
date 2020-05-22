static class MyExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        Class<?> testClass = extensionContext.getRequiredTestClass();
        if (testClass.getEnclosingClass() == null) {
            System.err.println("beforeAll: " + testClass.getName());
        }
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        Class<?> testClass = extensionContext.getRequiredTestClass();
        if (testClass.getEnclosingClass() == null) {
            System.err.println("afterAll: " + testClass.getName());
        }
    }
}
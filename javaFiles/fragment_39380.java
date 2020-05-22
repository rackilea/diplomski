public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    List<IMethodInstance> sortedMethods = new ArrayList<IMethodInstance>();
    for (IMethodInstance method : methods) {
        Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
        //testMethod would be "null" for "@DataProvider" annotated methods
        if (testMethod != null && testMethod.priority() == 1) {
            sortedMethods.add(method);
        }
    }
    return sortedMethods;
}
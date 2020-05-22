@DataProvider(name = "getDataForInstances")
public static Object[][] getDataForInstances(ITestContext context, ITestNGMethod method) {
    System.out.println("test name = " + context.getName());
    System.out.println("Method name = " + method.getConstructorOrMethod().getName() + "()\n");

    return new Object[][] {
      {Collections.singletonList("Java")},
      {Arrays.asList("TestNG", "JUnit")},
      {Arrays.asList("Maven", "Gradle", "Ant")}
    };
}
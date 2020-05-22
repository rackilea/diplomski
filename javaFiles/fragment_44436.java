public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
  List<IMethodInstance> result = new ArrayList<IMethodInstance>();
  for (IMethodInstance m : methods) {
    String expectedPackage = System.getProperty("package");
    Package p = m.getInstance().getClass().getPackage();
    if (p matches expectedPackage) {
      result.add(m);
    }
  }
  return result;
}
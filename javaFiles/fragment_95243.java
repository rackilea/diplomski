@Test
public void testPrivate() throws Throwable {
  final Class clazz = Class.forName("privateaccessor.tst.ProjectModel$MyStaticClass");
  // Get the private constructor ...
  final Constructor constructor = clazz.getDeclaredConstructor();
  // ... and make it accessible.
  constructor.setAccessible(true);
  // Then create an instance of class MyStaticClass.
  final Object instance = constructor.newInstance();
  // Invoke method model(). The primitive int return value will be
  // wrapped in an Integer.
  final Integer result = (Integer) PrivateAccessor.invoke(instance, "model", new Class[]{Object.class, Map.class}, new Object[]{null, null});
  assertEquals(42, result.intValue());
}
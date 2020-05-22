@Test
public void testIsFinal() throws NoSuchMethodException, SecurityException {
   Method method = TestClass.class.getMethod("testMethod", Integer.class);
   log.info("method {}", method);
   Parameter[] params = method.getParameters();
   log.info("params {}", params);
   log.info("params[0] {}", params[0]);
   log.info("modifiers {}", params[0].getModifiers());
   log.info("final {}", Modifier.isFinal( params[0].getModifiers() ));
}
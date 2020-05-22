public static interface BeanDelegate {
  String getValueFromDelegate();
}

@Test
public void testMethodDelegate() throws Exception {
  SimpleBean bean = new SimpleBean();
  bean.setValue("Hello world!");
  BeanDelegate delegate = (BeanDelegate) MethodDelegate.create(
      bean, "getValue", BeanDelegate.class);
  assertEquals("Hello world!", delegate.getValueFromDelegate());
}
@Test
public void testMulticastDelegate() throws Exception {
  MulticastDelegate multicastDelegate = MulticastDelegate.create(
      DelegatationProvider.class);
  SimpleMulticastBean first = new SimpleMulticastBean();
  SimpleMulticastBean second = new SimpleMulticastBean();
  multicastDelegate = multicastDelegate.add(first);
  multicastDelegate = multicastDelegate.add(second);

  DelegatationProvider provider = (DelegatationProvider)multicastDelegate;
  provider.setValue("Hello world!");

  assertEquals("Hello world!", first.getValue());
  assertEquals("Hello world!", second.getValue());
}
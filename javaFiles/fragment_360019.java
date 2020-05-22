// This code is untested, but should get the point across. Edits welcome.
// 2016-01-20: Integrated feedback from Georgios Stathis. Thanks Georgios!

@Test
public void callAllGetters() throws Exception {
  Person personSpy = spy(new Person());
  personSpy.getFirstname();
  personSpy.getLastname();

  assertAllGettersCalled(personSpy, Person.class);
}

private static void assertAllGettersCalled(Object spy, Class<?> clazz) {
  BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
  Set<Method> setOfDescriptors = beanInfo.getPropertyDescriptors()
      .stream()
      .map(PropertyDescriptor::getReadMethod)
      .filter(p -> !p.getName().contains("getClass"))
      .collect(Collectors.toSet());
  MockingDetails details = Mockito.mockingDetails(spy);
  Set<Method> setOfTestedMethods = details.getInvocations()
      .stream()
      .map(InvocationOnMock::getMethod)
      .collect(Collectors.toSet());
  setOfDescriptors.removeAll(setOfTestedMethods);
  // The only remaining descriptors are untested.
  assertThat(setOfDescriptors).isEmpty();
}
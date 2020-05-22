//make fields accessible for testing
private static void setFinalStatic(Field field, Object newValue) throws Exception {
      field.setAccessible(true);
      // remove final modifier from field
      Field modifiersField = Field.class.getDeclaredField("modifiers");
      modifiersField.setAccessible(true);
      modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
      field.set(null, newValue);
}   

@Test
@PrepareForTest({A.class})
public void testDoFooException() {
  A mockedA = PowerMockito.mock(A.class);
  B mockedB = PowerMockito.mock(B.class);

  try {
    setFinalStatic(Foo.class.getDeclaredField("localA"), mockedA);
  } catch (Exception e) {
    fail("setFinalStatic threw exception: " + e);
  }

  Mockito.when(mockedA.createB()).thenReturn(mockedB);
  PowerMockito.doThrow(new RuntimeException()).when(mockedB).doB(Mockito.anyString());

  FooResult fooResult = foo.doFoo("Hello Foo");
  assertNull(fooResult);
}
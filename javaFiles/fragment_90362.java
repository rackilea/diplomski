@Test
public void shouldReturnMethodArrayWithPlainJava() throws Exception {
    Method method = SomeAnnotatedController.class.getDeclaredMethod("someMethod");
    RequestMapping annotation = method.getAnnotation(RequestMapping.class);
    assertEquals(1, annotation.method().length);
    assertEquals(RequestMethod.GET, annotation.method()[0]);
}
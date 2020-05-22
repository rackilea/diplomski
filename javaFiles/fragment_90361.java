@Test
public void shouldReturnMethodArrayWithSpringMetadataReader() throws Exception {
    MetadataReader metadataReader = new CachingMetadataReaderFactory().getMetadataReader(SomeAnnotatedController.class.getName());
    Set<MethodMetadata> annotatedMethods = metadataReader.getAnnotationMetadata().getAnnotatedMethods(RequestMapping.class.getName());
    assertEquals(1, annotatedMethods.size());
    MethodMetadata methodMetadata = annotatedMethods.iterator().next();
    assertEquals("someMethod", methodMetadata.getMethodName());
    Map<String, Object> annotationAttributes = methodMetadata.getAnnotationAttributes(RequestMapping.class.getName());
    assertTrue(annotationAttributes.containsKey("method"));
    RequestMethod[] methodAttribute = (RequestMethod[]) annotationAttributes.get("method");
    assertEquals(1, methodAttribute.length);
}
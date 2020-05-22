@Test
public void testDocumentToStringTransformerException() throws Exception
{
    // Mocking Stuff
    PowerMockito.whenNew(StringWriter.class).withNoArguments().thenReturn(null);

    // Execute Method Under Test
    final String result = DOMUtil.documentToString(doc);

    // Verify Result
    assertNull(result);
}
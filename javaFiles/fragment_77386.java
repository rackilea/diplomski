@Test 
  public void testEmptyText() { 
    // set up the test class with a specific max length
    classUnderTest = new MaxLength(125); 
    // this shall be called from inside decorate()
    mockDocument.addDocumentListener(classUnderTest); 
    // the mock document shall always return an empty text
    EasyMock.expect(mockDocument.getText(0, 1)).andStubReturn(""); 
    // we expect this to be called from inside handle()
    mockHighlighter.removeAllHighlights();
    // start replay mode
    EasyMock.replay(mockComponent, mockEvent, mockDocument, mockHighlighter); 
    // inject mock component into tested object
    maxListener.decorate(mockComponent); 

    // call the tested method
    classUnderTest.handle(mockEvent); 

    // verify that all expected calls to the mocks have been made    
    EasyMock.verify(mockComponent, mockEvent, mockDocument, mockHighlighter); 
  }
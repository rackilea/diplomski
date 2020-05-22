private Component mockComponent;
private ClassUnderTest classUnderTest;
private DocumentEvent mockEvent;
private Document mockDocument;
private Highlighter mockHighlighter;

@Before
public void setUp() {
    mockComponent = createMock(Component.class);
    classUnderTest = new ClassUnderTest(mockComponent);
    mockEvent = createMock(DocumentEvent.class);
    mockDocument = createMock(Document.class);
    expect(mockEvent.getDocument()).andStubReturn(mockDocument);
    expect(mockDocument.getLength()).andReturn(1);
    mockHighlighter = createMock(Highlighter.class);
    expect(mockComponent.getHighlighter()).andReturn(mockHighlighter);
}

@Test
public void testEmptyText() {
    expect(mockDocument.getText(0, 1)).andStubReturn("");
    mockHighlighter.removeAllHighlights();
    replay(mockComponent, mockEvent, mockDocument, mockHighlighter);

    classUnderTest.handle(mockEvent);

    verify(mockComponent, mockEvent, mockDocument, mockHighlighter);
}
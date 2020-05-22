@RunWith(MockitoJUnitRunner.class)
public class XmlToCsvTest {
    @Mock
    DocumentBuilderFactory factory;

    @Mock
    StreamSource style source;

    @Mock
    TransformerFactory transformerFactory;

    @InjectMocks
    XmlToCsv sut; // System Under Test

    @Test
    public void testOk() throws Exception {
        // Mocks
        DocumentBuilder documentBuilder = Mockito.mock(DocumentBuilder.class);
        Document document = Mockito.mock(Document.class);
        // Now you control all objects created in the class and you can test if the right methods are called

        // when-clauses
        Mockito.when(factory.newDocumentBuilder).thenReturn(documentBuilder);
        Mockito.when(documentBuilder.parse(any(File.class)).thenReturn(document);
        // Add all when's here

        // now call the class
        sut.xmlToCsv("", "", "");

        // now verify all calls
        verify(factory, times(1)).newDocumentBuilder();
        verify(documentBuilder, times(1)).parse(any(File.class));
        // etc.
    }
}
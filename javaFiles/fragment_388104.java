@RunWith(PowerMockRunner.class)
@PrepareForTest({XmlToCsv.class, DocumentBuilderFactory.class})
public class XmlToCsvTest {

    XmlToCsv sut;

    @Test
    public void testXmlToCsv() throws Exception {
        DocumentBuilder documentBuilder = Mockito.mock(DocumentBuilder.class);
        Document document = Mockito.mock(Document.class);

        //when phase
        PowerMockito.mockStatic(DocumentBuilderFactory.newInstance).thenReturn(documentBuilder);
        Mockito.when(factory.newDocumentBuilder).thenReturn(documentBuilder);
        Mockito.when(documentBuilder.parse(any(File.class)).thenReturn(document);

        // now call the class
        sut.xmlToCsv("", "", "");

        //now verify

verify(documentBuilder, times(1)).parse(any(File.class));
    }
}
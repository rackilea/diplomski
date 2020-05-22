@BeforeTest
public void setup() {
    confluence1 = Mockito.mock(XWikiXmlRpcClient.class);
    Page testPage = new Page();
    when(confluence1.storePage(any(Page.class))).thenReturn(testPage);
    confluence2 = Mockito.mock(XWikiXmlRpcClient.class);
    publish = new Confluence(confluence1, confluence2);
}
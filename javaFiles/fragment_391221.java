@Test
public final void baseRequest_PostResponseReturned()
        throws IOException {

    // NOTE: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html
    // Go to the section 4.3.1 and look at the factory for providing custom beans.

    // Create our mock controller
    UrlWrapper mockUrl = mock(UrlWrapper.class);
    URLConnection mockUrlConn = mock(URLConnection.class);

    // set up the mockUrl
    when(mockUrl.openConnection()).thenReturn(mockUrlConn);
    when(mockUrlConn.getInputStream()).thenReturn(IOUtils.toInputStream("Success"));
    when(mockUrlConn.getOutputStream()).thenReturn(new PipedOutputStream(new PipedInputStream()));

    MockBeanProvider.enqueueMockUrl(mockUrl);

    // Set our mock context into our application.
    com.maddonkeysoftware.donkeydesktopmonitor.ContextProvider.setContext(new ClassPathXmlApplicationContext("testApplicationContext.xml"));

    MockBeanProvider p = (MockBeanProvider)ContextProvider.getContext().getBean("serviceLocator");

    // Create our object under test.
    AddImageRequest request = new AddImageRequest();
    request.setRequestUrl("http://testUrl.com");
    boolean result = request.post();

    // Verify that everything was called as expected.
    assertTrue(result);
}
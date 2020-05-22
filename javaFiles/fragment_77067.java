@RunWith(MockitoJUnitRunner.class)
public class AppStartUpContextListenerTest {

    public AppStartUpContextListenerTest() {
    }

    @Mock
    ServletContextEvent mockEvent;
    @Mock
    ServletContext mockServletContext;
    @Mock
    Configuration mockConfig;
    @Mock
    WebApplicationContext mockWebContext;

    /**
     * Test of contextInitialized method, of class AppStartUpContextListener.
     */
    @Test
    public void testContextInitialized() {
        System.out.println("testContextInitialized");

        when(mockEvent.getServletContext()).thenReturn(mockServletContext);

        when(mockServletContext.getAttribute(Matchers.anyString())).thenReturn(mockWebContext);

        AppStartUpContextListener instance = new AppStartUpContextListener();
        instance.contextInitialized(mockEvent);
        // TODO review the generated test code and remove the default call to fail.

        verify(mockEvent, times(1)).getServletContext();

    }

}
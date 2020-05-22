@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:springtest-test.xml"})
public class MyControllerTest {

    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Test
    public void testRedirect() throws Exception {
        assertRedirect("/shoes");
    }

    @Test
    public void testRedirect2() throws Exception {
        assertRedirect("/shoes/sandals.html");
    }

    @Test
    public void testRedirect3() throws Exception {
        assertRedirect("/shoes/sports/nike.html");
    }

    private void assertRedirect(String uri) throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest("GET", uri);
        MockHttpServletResponse response = new MockHttpServletResponse();

        Object handler = handlerMapping.getHandler(request).getHandler();
        ModelAndView modelAndView = handlerAdapter.handle(request, response, handler);

        RedirectView view = (RedirectView) modelAndView.getView();
        assertEquals("matching URL", "https://www.somewebsite.com/", view.getUrl());
    }
}
@RunWith( SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebRoot/WEB-INF/path/to/your-context.xml") 
public class YourControllerTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter adapter;


@Before
public void setUp(){
    this.request = new MockHttpServletRequest();
    this.response = new MockHttpServletResponse();
    this.adapter = new AnnotationMethodHandlerAdapter();
}


    @Test
    public void getMetricTypes() throws Exception{



        request.setRequestURI("/filter");
        request.setMethod("GET");
        request.setParameter("subject", "subject");
        request.setParameter("area", "area");    
        request.setParameter("onlyImmediateChildren", "onlyImmediateChildren");    
        request.setParameter("componentGroup", "componentGroup");    
        request.setParameter("hasComponentGroups", "hasComponentGroups");    

        ModelAndView mav = adapter.handle(request, response, yourController);
        Assert.assertEquals(200, response.getStatus());
        //Assert what you want
    }
}
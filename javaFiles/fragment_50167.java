@WebService(name = "MyService" /*...*/)
public class MyService {

    @Resource
    private WebServiceContext wsc;

    @WebMethod
    public MyResponse process(MyRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) wsc.getMessageContext().get(MessageContext.SERVLET_REQUEST);

        httpRequest.getRemoteAddr(); // access some parameters...

        return new MyResponse();
    }

}
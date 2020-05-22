public class MyServiceImpl extends RemoteServiceServlet implements MyService {

    @Override
    public String processCall( String payload ) {
        HttpServletRequest req = getThreadLocalRequest();
        HttpSession session = req.getSession();
    }
}
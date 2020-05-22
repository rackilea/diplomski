@Controller("bmoa")
public class BMOAServlet implements HttpRequestHandler {



    /**
     * 
     */
    @RequestMapping("/bmoa-surrounds/bmoa")
    public void handleRequest(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException,
            IOException {

         response.getWriter().write("result=" + handleIncomingMessage(request));
    }
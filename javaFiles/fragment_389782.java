@WebServlet("/processes/edit/*")
public class ProcessEditServlet extends HttpServlet {
// you may get a logger over Dependency Injection or joust create one here... 
private final Logger logger;
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    ...


    if(validateRequest(request,logger){
    request.getRequestDispatcher("/WEB-INF/processEdit.jsp").forward(
        request, response);
    }else{
        response.sendError(404);
    }
}

public static boolean validateRequest(Request request,Logger logger){
    try {
        id = StringManipulation.removeSlashes(request.getPathInfo());
        numid = Integer.parseInt(id);
    } catch (Exception e) {
        logger.log(e); // you should at least log the exception
        return false;
    } 
    return true;
}
}
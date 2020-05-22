public class ServletImpl extends HttpServlet implements Servlet {

    ....
    public ServletImpl() {
      super();      
    }

 public void init(ServletConfig config) throws ServletException{
    super.init(config);         


    /*
     Application scope 
     Shared between all servlets, JSP pages, and custom tags within a J2EE application 
     or within the whole container if no applications are defined.
     The programmatic interface to the application scope is the 'ServletContext' object.         
     */


    ServletContext context = config.getServletContext();
    context.setAttribute("base", config.getInitParameter("base"));
      /* where "base" is iniy param in web.xml
         <init-param>
    <param-name>base</param-name>
    <param-value>/ServlrtName/sys</param-value>
    </init-param>       


       */



....



}
    ....
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
{
    doPost(request, response);
}


    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
   {
    Enumeration<?> paramNames = request.getParameterNames();


    while(paramNames.hasMoreElements()) {

        String paramName = (String)paramNames.nextElement();

        String[] paramValues = request.getParameterValues(paramName);


         if("sub".equals(paramName)){

            paramValues = request.getParameterValues(paramName);

            if(paramValues.length > 0){

                String param = paramValues[0];
                // do something
                ....
            }               

        }           
    }
}


....
// prepear response 
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    out.println(mMessageResponseStr);
    out.close();
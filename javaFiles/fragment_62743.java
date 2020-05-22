public class ServletAbc extends GenericServlet {
    public void service(ServletRequest req,ServletResponse res)
                        throws ServletException, IOException{
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello JSP</title>");
        out.println("</head>");
        out.println("<body>");
        for(int i=0; i<10; i++){
            out.print("Loop number " + i);
        }
        out.println("</body>");
        out.println("</html>");
    }
}
public class SubstitutionServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

@Override
 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/report.jsp");
     final ByteArrayOutputStream buf = new ByteArrayOutputStream();
     final PrintWriter out = new PrintWriter(buf); //CREATE ONLY ONE WRITER
     ServletResponseWrapper wrapper = new HttpServletResponseWrapper(response) {
         @Override
         public PrintWriter getWriter() throws IOException {
             return out; // REUSE WRITER
         }
     };
     dispatcher.forward(request, wrapper);
     String html = buf.toString("UTF-8"); // "" is returned
     System.out.println(html);
     response.getOutputStream().print("Completed");
   }
}
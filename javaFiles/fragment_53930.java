package ajax;

 import java.io.IOException;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 public class UpdateListsServlet extends HttpServlet 
 {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse  response) throws ServletException, IOException 
    { 
       String name = null;
       name = request.getParameter("user");

       if(request.getParameter("user").toString().equals(""))
           name="Hello User";

           response.setContentType("text/plain");  
           response.setCharacterEncoding("UTF-8"); 
           response.getWriter().write(name); 
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse 
   response) throws ServletException, IOException {}

}
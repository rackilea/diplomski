public class LoginServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  

response.setContentType("text/html");  
PrintWriter out = response.getWriter();  

String n=request.getParameter("useremail");  
String p=request.getParameter("password");  

if(LoginDao.validate(n, p)){  
    RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
    rd.forward(request,response);  
}  
else{  
    out.print("Sorry username or password error");  
    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
    rd.include(request,response);  
}  

out.close();  
}  
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Locale;

public class GetLocale extends HttpServlet{

  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
  {
      Locale locale = request.getLocale();
      String language = locale.getLanguage();
      String country = locale.getCountry();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println(language + ":" + country);
  }
}
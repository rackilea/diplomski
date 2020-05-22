package app.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseRedirectionServlet extends HttpServlet
{
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException
  {
    String url = 'http://www.siteB.com';
    response.setHeader("token", "kjsydis9d979as8dh87"); //some value that your server is generating

    response.sendRedirect(url);
  }
}
import java.io.IOException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyFilter {

  public static void main(final String[] args) throws Exception {
    Server server = new Server(8080);

    ServletHandler handler = new ServletHandler();
    server.setHandler(handler);

    handler.addServletWithMapping(HelloServlet.class, "/*");
    handler.addFilterWithMapping(HelloPrintingFilter.class, "/*",
        EnumSet.of(DispatcherType.REQUEST));

    server.start();
    server.join();
  }

  public static class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      response.setContentType("text/html");
      response.setStatus(HttpServletResponse.SC_OK);
      response.getWriter().println("<h1>Hello SimpleServlet</h1>");
    }
  }

  public static class HelloPrintingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
      System.out.print("hello from filter");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void destroy() {}
  }
}
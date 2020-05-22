package jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ObjectPassingExample
{
    public static void main(String args[]) throws Exception
    {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        // Option 1: Direct servlet instantiation and ServletHolder
        HelloServlet hello = new HelloServlet("everyone");
        ServletHolder helloHolder = new ServletHolder(hello);
        context.addServlet(helloHolder, "/hello/*");

        // Option 2: Using ServletContext attribute
        context.setAttribute("my.greeting", "you");
        context.addServlet(GreetingServlet.class, "/greetings/*");

        server.setHandler(context);
        server.start();
        server.join();
    }

    public static class HelloServlet extends HttpServlet
    {
        private final String hello;

        public HelloServlet(String greeting)
        {
            this.hello = greeting;
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            resp.setContentType("text/plain");
            resp.getWriter().println("Hello " + this.hello);
        }
    }

    public static class GreetingServlet extends HttpServlet
    {
        private String greeting;

        @Override
        public void init() throws ServletException
        {
            this.greeting = (String) getServletContext().getAttribute("my.greeting");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            resp.setContentType("text/plain");
            resp.getWriter().println("Greetings to " + this.greeting);
        }
    }
}
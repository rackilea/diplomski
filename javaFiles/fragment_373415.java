import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trinary.test.service.TestService;

public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = -1778574173539761350L;

    @Inject TestService testService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("PATH: " + req.getPathInfo());

        testService.method(...);

        // ...

        resp.setContentType("text/html");
        resp.getWriter().append("<html><h1>TESTY TEST!</h1></html>");
    }
}
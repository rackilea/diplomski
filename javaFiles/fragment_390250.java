import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventServlet", urlPatterns = {"/EventServlet"}, asyncSupported = true)
public class EventServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/event-stream; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Transfer-Encoding", "Chunked");
        response.flushBuffer();
        final AsyncContext ctx = request.startAsync();
        ctx.setTimeout(0);

        ctx.start(new Runnable() {
            @Override
            public void run() {

                try {

                    Writer out = ctx.getResponse().getWriter();
                    for (;;) {
                        out.write("event: simpleEvent\n");
                        out.write("data:" + randomString(25000) + "\n\n");
                        ctx.getResponse().flushBuffer();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    ctx.complete();
                }

            }
        });

    }
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
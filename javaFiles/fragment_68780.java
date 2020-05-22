@WebServlet(name = "MyWebSocketServlet", urlPatterns = {"/myurl"})
public class MyWebSocketServlet extends WebSocketServlet {
    private final static int IDLE_TIME = 60 * 1000;

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(IDLE_TIME);
        factory.setCreator(new CustomWebSocketCreator());
    }
}
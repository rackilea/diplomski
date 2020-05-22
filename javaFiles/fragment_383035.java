public class WSServlet extends WebSocketServlet {

    ...
    ...

    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest req, String str) {
        System.out.println("IP: "+ req.getRemoteAddr());
        ...
    }
}
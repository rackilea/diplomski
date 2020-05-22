public class RequestHandler implements HttpHandler {

    private final Object someObject;

    public RequestHandler(Object someObject) {
        // there is an implied super() here
        this.someObject = someObject;
    }

    public void handle(HttpExchange exchange) throws IOException {
       ...
       // you can then use someObject here
       ...
    }
}
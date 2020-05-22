public class HttpServer extends Server<HttpRequestHandler> {

    protected HttpRequestHandler wrapSocket(Socket socket) {
        return new HttpRequestHandler(socket);
    }

}
public class Server {
    ...
    public void handleServerRequest(InputStream is) {
        // parse the input stream
        String path = // get from stream
        String requestType = // get from stream
        MyHandler handler = handlers.get(path);
        MyHttpRequest request = new MyHttpRequest();
        // set request properties.
        MyHttpResponse response = new MyHttpResponse();
        if ("GET".equals(requestType)) {
            handler.doGet(request, response);
        } else if ("POST".equals(requestType)) {
            handler.doPost(request, response);
        } else {
            throws new BadRequestException(..);
        }
    }
}
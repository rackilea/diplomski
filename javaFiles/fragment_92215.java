public interface MyHandler {
    void doGet(MyHttpRequest request, MyHttpResponse response);
    void doPost(MyHttpRequest request, MyHttpResponse response);
}
public class MyHandlerImpl implements MyHandler {
    @Override
    public void doGet(MyHttpRequest request, MyHttpResponse response) {}
    @Override
    public void doPost(MyHttpRequest request, MyHttpResponse response) {}
}
public class Server {
    private Map<String, MyHander> handlers = new HashMap<String, MyHandler>();
    public void registerHandler(String path, MyHandler handler) {
        handler.put(path, handler);
    }
}
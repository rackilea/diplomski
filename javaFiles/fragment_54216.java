import ext.ResponseHandler;

public class Handler implements ResponseHandler {
    private KrollModule proxy; // Hold onto this reference
    public Handler(KrollModule proxy) {
        this.proxy = proxy;
    }

    public void OnConnected(String arg0, String arg1) {
        // Fire event if anyone is listening
        if (proxy.hasListeners("colorChange")) {
            HashMap<String, Object> event = new HashMap<String, Object>();
            event.put("u1", arg0);
            event.put("u2", arg1);
            proxy.fireEvent("colorChange", hm);
        }
    }
}
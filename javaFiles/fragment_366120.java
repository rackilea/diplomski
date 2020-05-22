import sun.org.mozilla.javascript.internal.Context;
import sun.org.mozilla.javascript.internal.Function;

public class JSTestClient {

    private Function successCallback;

    public void handleSuccess(Function successCallback) {
        this.successCallback = successCallback;
    }

    public void doStuff() {
        this.successCallback.call(Context.getCurrentContext(), null, null,
                                  new Object[] { "TEST SUCCESS" });
    }
}
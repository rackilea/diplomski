import play.GlobalSettings;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.lang.reflect.Method;

public class Global extends GlobalSettings {

    @Override
    public Action onRequest(final Http.Request request, Method method) {
        if ("GET".equals(request.method()) && "www.example.com".equals(request.host())) {
            return new Action.Simple() {
                public Result call(Http.Context ctx) throws Throwable {
                    return movedPermanently("http://example.com" + request.path());
                }
            };
        }
        return super.onRequest(request, method);
    }
}
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final class ApplicationContext {
        private final String app;
        private final String ctx;

        public ApplicationContext(final String app, final String ctx) {
            this.app = app;
            this.ctx = ctx;
        }

        @Override
        public String toString() {
            return "ApplicationContext[" + app + "/" + ctx + "]";
        }
    }

    private static ApplicationContext ac(final String app, final String ctx) {
        return new ApplicationContext(app, ctx);
    }

    private static ApplicationContext getApplicationContext(final String url,
            final Map<String, ApplicationContext> urlMap) {
        String specificUrl = url;
        ApplicationContext result = null;
        while (specificUrl != null && result == null) {
            result = urlMap.get(specificUrl);
            specificUrl = shortenUrl(specificUrl);
        }

        return result;
    }

    public static void main(final String[] args) throws Exception {
        final Map<String, ApplicationContext> urlMap = new HashMap<String, ApplicationContext>();
        urlMap.put("/application1", ac("Application1", "Root"));
        urlMap.put("/application1/subcontext1", ac("Application1", "SubContext1"));
        urlMap.put("/application1/subcontext2", ac("Application1", "SubContext2"));
        urlMap.put("/application1/subcontext2/subcontext3", ac("Application1", "SubContext3"));
        urlMap.put("/application2", ac("Application2", null));

        System.out.println(getApplicationContext("/application1/", urlMap));
        System.out.println(getApplicationContext("/application1/abc", urlMap));
        System.out.println(getApplicationContext("/application1/subcontext2/abc", urlMap));
    }

    private static String shortenUrl(final String url) {
        final int index = url.lastIndexOf('/');
        if (index > 0) {
            return url.substring(0, index);
        }
        else {
            return null;
        }
    }
}
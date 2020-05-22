class AppProvider {
    public static final ThreadLocal<String> APP_CONTEXT = new ThreadLocal<String>();
}

class Controller {
    public void users(@RequestParam String id) {
        AppProvider.APP_CONTEXT.set(id);
        .......
    }
}

class Service {
    try {
    } catch (Exception e) {
        log.error(String.format("Id: %s", AppProvider.APP_CONTEXT.get()));
    }
}
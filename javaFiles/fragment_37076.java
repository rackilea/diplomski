public class LogContext {

    private static ThreadLocal<String> localCorrelationId = new ThreadLocal<String>();
    private static ThreadLocal<String> localUserId = new ThreadLocal<String>();

    public static String getCorrelationId() {
        return localCorrelationId.get();
    }

    public static void setCorrelationId(String correlationId) {
        localCorrelationId.set(correlationId);
    }

    public static String getUserId() {
        return localUserId.get();
    }

    public static void setUserId(String userId) {
        localUserId.set(userId);
    }

    public static void cleanup() {
        localCorrelationId.remove();
        localUserId.remove();
    }
}
public final class SessionUtils {
    @SuppressWarnings("unchecked")
    public static <T> T getSessionAttribute(HttpSession session, String name) {
        return (T) session.getAttribute(name);
    }
}
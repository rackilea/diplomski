public class SecurityChecker {

    public static boolean isSecured() {
        // Whatever
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }
}
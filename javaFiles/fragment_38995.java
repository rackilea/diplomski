public class SessionUser {
    private static SessionUser instance = null;
    protected SessionUser() {
      // Exists only to defeat instantiation.
    }

    public static SessionUser getInstance() {
        if(instance == null) {
            instance = new SessionUser();
         }
         return instance;
    }

    private boolean isUserInSession()
    {
        //validation code
        return isInSession;
    }
}
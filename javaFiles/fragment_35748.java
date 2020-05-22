public class Login implements PhaseListener {
    private static final String USER_LOGIN_OUTCOME = "login";
     @Override
        public void afterPhase(PhaseEvent event) {
            FacesContext context = event.getFacesContext();
            if (userExists(context)) {
                // 1. Update last login
                // 2. may be expired ???
                ExternalContext extContext = context.getExternalContext();
                try {
                    ETT_UserDTL tmpUser = (ETT_UserDTL) extContext.getSessionMap().get(User.USER_SESSION_KEY);
                    if (!Authenticator.authenticateUser(tmpUser, context)) {
                        // send the user to the login view
                        reLogin(context);
                    } else {
                        ;
                    }
                    // allow processing of the requested view
                } catch (Exception ex) {
                    SystemLogger.getLogger().error(ex);
                    ClientMessage.logErr(ex.toString());
                    reLogin(context);
                }
            } else {
                // send the user to the login view
                reLogin(context);
            }
        }
    private boolean userExists(FacesContext context) {
    // Need re-check authenticator here.
    // Check user exist
    ExternalContext extContext = context.getExternalContext();
    return (extContext.getSessionMap().containsKey(User.USER_SESSION_KEY));
}
private void reLogin(FacesContext context) {
        // send the user to the login view
        if (requestingSecureView(context)) {
            context.responseComplete();
            context.getApplication().
                    getNavigationHandler().handleNavigation(context,
                    null,
                    USER_LOGIN_OUTCOME);
        } else {
            ;
        }
    }
    }
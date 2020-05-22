public String intercept (ActionInvocation invocation) throws Exception {
    // Get the action context from the invocation so we can access the
    // HttpServletRequest and HttpSession objects.
    final ActionContext context = invocation.getInvocationContext ();
    HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
    HttpSession session =  request.getSession (true);

    // Is there a "user" object stored in the user's HttpSession?
    Object user = session.getAttribute (USER_HANDLE);
    if (user == null) {
        // The user has not logged in yet.

        // Is the user attempting to log in right now?
        String loginAttempt = request.getParameter (LOGIN_ATTEMPT);
        if (! StringUtils.isBlank (loginAttempt) ) { // The user is attempting to log in.

            // Process the user's login attempt.
            if (processLoginAttempt (request, session) ) {
                // The login succeeded send them the login-success page.
                return "login-success";
            } else {
                // The login failed. Set an error if we can on the action.
                Object action = invocation.getAction ();
                if (action instanceof ValidationAware) {
                    ((ValidationAware) action).addActionError ("Username or password incorrect.");
                }
            }
        }

        // Either the login attempt failed or the user hasn't tried to login yet, 
        // and we need to send the login form.
        return "login";
    } else {
        return invocation.invoke ();
    }
}
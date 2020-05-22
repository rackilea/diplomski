/**
 * Authenticate the user making this request, based on the specified
 * login configuration.  Return <code>true if any specified
 * constraint has been satisfied, or <code>false if we have
 * created a response challenge already.
 *
 * @param request Request we are processing
 * @param response Response we are creating
 * @param config    Login configuration describing how authentication
 *              should be performed
 *
 * @exception IOException if an input/output error occurs
 */
public boolean authenticate(Request request,
                            Response response,
                            LoginConfig config)
    throws IOException {

    // Have we already authenticated someone?
    Principal principal = request.getUserPrincipal();
    String ssoId = (String) request.getNote(Constants.REQ_SSOID_NOTE);
    if (principal != null) {
        if (log.isDebugEnabled())
            log.debug("Already authenticated '" + principal.getName() + "'");
        // Associate the session with any existing SSO session
        if (ssoId != null)
            associate(ssoId, request.getSessionInternal(true));
        return (true);
    }

    // Is there an SSO session against which we can try to reauthenticate?
    if (ssoId != null) {
        if (log.isDebugEnabled())
            log.debug("SSO Id " + ssoId + " set; attempting " +
                      "reauthentication");
        /* Try to reauthenticate using data cached by SSO.  If this fails,
           either the original SSO logon was of DIGEST or SSL (which
           we can't reauthenticate ourselves because there is no
           cached username and password), or the realm denied
           the user's reauthentication for some reason.
           In either case we have to prompt the user for a logon */
        if (reauthenticateFromSSO(ssoId, request))
            return true;
    }

    // Validate any credentials already included with this request
    String username = null;
    String password = null;

    MessageBytes authorization = 
        request.getCoyoteRequest().getMimeHeaders()
        .getValue("authorization");

    if (authorization != null) {
        authorization.toBytes();
        ByteChunk authorizationBC = authorization.getByteChunk();
        if (authorizationBC.startsWithIgnoreCase("basic ", 0)) {
            authorizationBC.setOffset(authorizationBC.getOffset() + 6);
            // FIXME: Add trimming
            // authorizationBC.trim();

            CharChunk authorizationCC = authorization.getCharChunk();
            Base64.decode(authorizationBC, authorizationCC);

            // Get username and password
            int colon = authorizationCC.indexOf(':');
            if (colon < 0) {
                username = authorizationCC.toString();
            } else {
                char[] buf = authorizationCC.getBuffer();
                username = new String(buf, 0, colon);
                password = new String(buf, colon + 1, 
                        authorizationCC.getEnd() - colon - 1);
            }

            authorizationBC.setOffset(authorizationBC.getOffset() - 6);
        }

        principal = context.getRealm().authenticate(username, password);
        if (principal != null) {
            register(request, response, principal, Constants.BASIC_METHOD,
                     username, password);
            return (true);
        }
    }


    // Send an "unauthorized" response and an appropriate challenge
    MessageBytes authenticate = 
        response.getCoyoteResponse().getMimeHeaders()
        .addValue(AUTHENTICATE_BYTES, 0, AUTHENTICATE_BYTES.length);
    CharChunk authenticateCC = authenticate.getCharChunk();
    authenticateCC.append("Basic realm=\"");
    if (config.getRealmName() == null) {
        authenticateCC.append(request.getServerName());
        authenticateCC.append(':');
        authenticateCC.append(Integer.toString(request.getServerPort()));
    } else {
        authenticateCC.append(config.getRealmName());
    }
    authenticateCC.append('\"');        
    authenticate.toChars();
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    //response.flushBuffer();
    return (false);

}
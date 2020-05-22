/**
* Addition to standard shiro code
* User logs in with his {@link principal} (username) but login needs to be performed with his cn instead
* The addition is an ldap query to get the users cn from the ldap server and store it (instead of the given principal) in the return String
* @return UserDN with user uid (cn) instead of principal (username)
*/
@Override
protected String getUserDn( final String principal ) throws IllegalArgumentException, IllegalStateException {

    if (!StringUtils.hasText(principal)) {
        throw new IllegalArgumentException("User principal cannot be null or empty for User DN construction.");
    }
    String prefix = getUserDnPrefix();
    String suffix = getUserDnSuffix();
    if (prefix == null && suffix == null) {
        log.debug("userDnTemplate property has not been configured, indicating the submitted " +
                  "AuthenticationToken's principal is the same as the User DN.  Returning the method argument " +
                  "as is.");
        return principal;
    }

    int prefixLength = prefix != null ? prefix.length() : 0;
    int suffixLength = suffix != null ? suffix.length() : 0;
    StringBuilder sb = new StringBuilder(prefixLength + principal.length() + suffixLength);
    if (prefixLength > 0) {
        sb.append(prefix);
    }

    /*############################################################################################
    * ADDITION TO STANDARD SHIRO CODE 
    * User logs in with his {@link principal} (username) but login needs to be performed with his cn instead
    *    => translate username to cn
    */
    AppSettings_Controler settings = Startup.getAppSettingsControler();
    LDAP_Manager ldap_manager = new LDAP_Manager();
    LdapContext ctx = ldap_manager.getLdapConnection();
    String user_uid = "";

    SearchControls constraints = new SearchControls();
    constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
    String[] attrIDs = {"cn"};
    constraints.setReturningAttributes(attrIDs);
    NamingEnumeration answer = null;

    try{
        answer = ctx.search(settings.get_ldap_search_dn_1(), settings.get_ldap_uname_field_name_1() + "=" + principal, constraints);
        if (answer.hasMore()) {
            Attributes attrs = ((SearchResult) answer.next()).getAttributes();
            user_uid = attrs.get("cn").toString().substring(attrIDs[0].length() + 2);
        } else {
            throw new Exception("Invalid User");
        }
    } catch (Exception ex) {
        // Error Handling & Fallback to my second LDAP-Server
        try{
            answer = ctx.search(settings.get_ldap_search_dn_2(), settings.get_ldap_uname_field_name_2() + "=" + principal, constraints);
            if (answer.hasMore()) {
                Attributes attrs = ((SearchResult) answer.next()).getAttributes();
                user_uid = attrs.get("cn").toString().substring(attrIDs[0].length() + 2);
            } else {
                throw new Exception("Invalid User");
            }
        }catch (Exception exe) {
            // Error Handling
        }
    }
    try {
        ctx.close();
    } catch (NamingException ex) {
        JndiLdapRealm_custom_error_logger.error("getUserDn(); Fehler beim schließen: ", ex);
    }
    //############################################################################################

    //############################################################################################
    // Shiro Standard Code -> add principal to String
    //sb.append(principal);
    /*############################################################################################

    /*############################################################################################
    * ALTERED CODE
    * Instead -> Add user's cn to String   
    */
    sb.append(user_uid);
    //############################################################################################

    if (suffixLength > 0) {
        sb.append(suffix);
    }
    return sb.toString();
}
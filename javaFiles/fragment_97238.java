public static Boolean validateLogin(String userName, String userPassword) {
    Hashtable<String, String> env = new Hashtable<String, String>();


    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, "ldap://" + LDAP_SERVER + ":" + LDAP_SERVER_PORT + "/" + LDAP_BASE_DN);

    // To get rid of the PartialResultException when using Active Directory
    env.put(Context.REFERRAL, "follow");

    // Needed for the Bind (User Authorized to Query the LDAP server) 
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, LDAP_BIND_DN);
    env.put(Context.SECURITY_CREDENTIALS, LDAP_BIND_PASSWORD);

    DirContext ctx;
    try {
       ctx = new InitialDirContext(env);
    } catch (NamingException e) {
       throw new RuntimeException(e);
    }

    NamingEnumeration<SearchResult> results = null;

    try {
       SearchControls controls = new SearchControls();
       controls.setSearchScope(SearchControls.SUBTREE_SCOPE); // Search Entire Subtree
       controls.setCountLimit(1);   //Sets the maximum number of entries to be returned as a result of the search
       controls.setTimeLimit(5000); // Sets the time limit of these SearchControls in milliseconds

       String searchString = "(&(objectCategory=user)(sAMAccountName=" + userName + "))";

       results = ctx.search("", searchString, controls);

       if (results.hasMore()) {

           SearchResult result = (SearchResult) results.next();
           Attributes attrs = result.getAttributes();
           Attribute dnAttr = attrs.get("distinguishedName");
           String dn = (String) dnAttr.get();

           // User Exists, Validate the Password

           env.put(Context.SECURITY_PRINCIPAL, dn);
           env.put(Context.SECURITY_CREDENTIALS, userPassword);

           new InitialDirContext(env); // Exception will be thrown on Invalid case
           return true;
       } 
       else 
           return false;

    } catch (AuthenticationException e) { // Invalid Login

        return false;
    } catch (NameNotFoundException e) { // The base context was not found.

        return false;
    } catch (SizeLimitExceededException e) {
        throw new RuntimeException("LDAP Query Limit Exceeded, adjust the query to bring back less records", e);
    } catch (NamingException e) {
       throw new RuntimeException(e);
    } finally {

       if (results != null) {
          try { results.close(); } catch (Exception e) { /* Do Nothing */ }
       }

       if (ctx != null) {
          try { ctx.close(); } catch (Exception e) { /* Do Nothing */ }
       }
    }
}
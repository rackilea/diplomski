public class LDAPAuthentication {

    static String ATTRIBUTE_FOR_USER = "sAMAccountName";

    @SuppressWarnings("unchecked")
    public Attributes authenticateUser(String username, String password, String strDomain, String strHost, String dn) throws NamingException {

        String searchFilter = "(&(objectClass=user)(" + ATTRIBUTE_FOR_USER + "=" + username + "))";
        // Create the search controls

        SearchControls searchCtls = new SearchControls();
        // searchCtls.setReturningAttributes(returnedAtts);
        // Specify the search scope
        searchCtls.setSearchScope(SearchControls.OBJECT_SCOPE);
        String searchBase = dn;
        Hashtable environment = new Hashtable();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        // Using starndard Port, check your instalation
        environment.put(Context.PROVIDER_URL, "ldap://" + strHost);
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");

        environment.put(Context.SECURITY_PRINCIPAL, username + "@" + strDomain);
        environment.put(Context.SECURITY_CREDENTIALS, password);

        LdapContext ctxGC = null;
        try {
            ctxGC = new InitialLdapContext(environment, null);
            // Search for objects in the GC using the filter
            NamingEnumeration answer = ctxGC.search(searchBase, searchFilter, searchCtls);
            while (answer.hasMoreElements()) {
                SearchResult sr = (SearchResult) answer.next();
                Attributes attrs = sr.getAttributes();
                if (attrs != null) {
                    return attrs;
                }
            }
        } catch (Exception e) {
            SystemLogger.getLogger().error(e);
        }
        return null;
    }
}
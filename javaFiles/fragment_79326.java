env = new Hashtable<String, String>();
env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.SECURITY_AUTHENTICATION, "simple");
env.put(Context.PROVIDER_URL, "<LDAP HOST>");
env.put(Context.SECURITY_PRINCIPAL, "<LDAP USER LOGIN>");
env.put(Context.SECURITY_CREDENTIALS, "<LDAP USER PASSWORD>");

LdapContext context = new InitialLdapContext(env);
// To get only 1000 results at a time.
context.setRequestControls(
    new Control[]{new PagedResultsControl(1000, Control.CRITICAL))});

String attrs = "<List of attrs to be retrieved for each matching LDAP entry>";
String base = "<Base of the search tree>";
String filter = "<Your filter>";
SearchControls controls = new SearchControls();
controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
controls.setReturningAttributes(attrs);
SearchResults searchResults;
do {
    searchResults = ctx.search(base, filter, controls);
    while (searchResults.hasMoreElements()) {
        // Process result.
    }
    // Process response controls to get the cookie 
    // and keep searching until it is null.
}
while (cookie is not null);
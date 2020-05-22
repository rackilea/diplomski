public static  DirContext connectJndi() throws NamingException {

    Hashtable<String, String> env = new Hashtable<String, String>(); 
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, "ldap://192.168.0.60:389");
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, "your id");
    env.put(Context.SECURITY_CREDENTIALS, "your password");
    //DirContext ctx = new InitialDirContext(env); 
    LdapContext ctx = new InitialLdapContext(env,null);
    return ctx;
} 


public static void lookupJndi() throws NamingException {
    //DirContext ctx = connectJndi();
    LdapContext ctx = (LdapContext) connectJndi();
    SearchControls ctls = new SearchControls();
    ctls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
    //ctls.setReturningAttributes(new String[] {"cn"});
    //String searchFilter=String.format("(cn=%s)", "cn" );
    String searchFilter="(objectClass=*)";
    //String searchFilter="(o=*)";

    NamingEnumeration<javax.naming.directory.SearchResult> results
     = ctx.search("c=kr", searchFilter,ctls);
    while(results.hasMoreElements()){
        javax.naming.directory.SearchResult sr = results.next();
        Attributes attrs = sr.getAttributes();
        //System.out.println(sr);
        System.out.println(attrs);
    }   
} // method
Hashtable<String, String> env = new Hashtable<String, String>();
env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.PROVIDER_URL, "LDAP://url/");

env.put(Context.SECURITY_AUTHENTICATION, "simple");
env.put(Context.SECURITY_PRINCIPAL, "domain\\user_name");
env.put(Context.SECURITY_CREDENTIALS, "password");

InitialLdapContext ctx = new InitialLdapContext(env,null);
boolean authenticated = (ctx != null) ? true : false;
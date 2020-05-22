public static Hashtable<String, String> getContextEnv() {
  Hashtable<String, String> contextEnv = new Hashtable<String, String>();
  contextEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
  contextEnv.put(Context.PROVIDER_URL, "ldap://dc.mydomain.com:3268");
  contextEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
  contextEnv.put(Context.SECURITY_PRINCIPAL, "CN=TECHNICAL_USER,DC=mydomain,DC=com");
  contextEnv.put(Context.SECURITY_CREDENTIALS, "TECHNICAL_USER_PASSWORD");
  contextEnv.put("java.naming.referral", "follow");
  contextEnv.put("java.naming.ldap.derefAliases", "never");
  contextEnv.put("com.sun.jndi.ldap.connect.pool", "true");
  contextEnv.put("com.sun.jndi.ldap.connect.timeout", "60000");

  return contextEnv;
}
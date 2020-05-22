@Resource(name = "ldap/users")
private LdapContext ldapContext;

Hashtable environment = ldapContext.getEnvironment().clone();
environment.put(Context.SECURITY_PRINCIPAL, userDN);
environment.put(Context.SECURITY_CREDENTIALS, userPassword);

DirContext dirContext = new InitialDirContext(environment);
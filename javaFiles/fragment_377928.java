properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
properties.put(Context.PROVIDER_URL, "LDAP://yourldap:389");
properties.put(Context.SECURITY_PRINCIPAL, ldapqueryuser + "@yourldap");
properties.put(Context.SECURITY_CREDENTIALS, ldapqueryuserpassword);

// initializing active directory LDAP connection
dirContext = new InitialDirContext(properties);
dirContext.search(name, filter, cons)
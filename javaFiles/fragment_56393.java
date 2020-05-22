public static void loadData() throws Exception
    {
        // Bind to the directory
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://127.0.0.1:10389");
        contextSource.setUserDn("uid=admin,ou=system");
        contextSource.setPassword("secret");
        contextSource.setPooled(false);
        contextSource.afterPropertiesSet();
        // Create the Sprint LDAP template
        LdapTemplate template = new LdapTemplate(contextSource);
        // Clear out any old data - and load the test data
     LdapTestUtils.cleanAndSetup(
                contextSource,
                LdapUtils.newLdapName("dn to remove"),
                new ClassPathResource("schema.ldif"));

          }
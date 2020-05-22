try {
    LdapContext ctx = new InitialLdapContext(env, null);
    ctx.setRequestControls(null);
    NamingEnumeration<?> namingEnum = ctx.search("ou=people,dc=example,dc=com", "(objectclass=user)", getSimpleSearchControls());
    while (namingEnum.hasMore ()) {
        SearchResult result = (SearchResult) namingEnum.next ();    
        Attributes attrs = result.getAttributes ();
        System.out.println(attrs.get("cn"));

    } 
    namingEnum.close();
} catch (Exception e) {
    e.printStackTrace();
}

private SearchControls getSimpleSearchControls() {
    SearchControls searchControls = new SearchControls();
    searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
    searchControls.setTimeLimit(30000);
    //String[] attrIDs = {"objectGUID"};
    //searchControls.setReturningAttributes(attrIDs);
    return searchControls;
}
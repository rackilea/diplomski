public String getUserName(String username, LdapContext ctx) {
    try {
        SearchControls constraints = new SearchControls();
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);

        String[] attrIDs = {"cn"};
        constraints.setReturningAttributes(attrIDs);

        NamingEnumeration answer = ctx.search("OU=Employees,OU=Users,DC=sub_domain,DC=domain,DC=com", "uid=" + username, constraints);

        if (answer.hasMore()) {
            Attributes attrs = ((SearchResult) answer.next()).getAttributes();
            return attrs.get("cn").toString().replace("cn:", "");
        } else {
            return null;
        }

    } catch (Exception ex) {
    }
    return null;
}
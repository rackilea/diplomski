public ArrayList<String> getAllUsers(LdapContext ctx) {
    ArrayList<String> users = new ArrayList<>();
    try {
        SearchControls constraints = new SearchControls();
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);

        String[] attrIDs = {"cn"};
        constraints.setReturningAttributes(attrIDs);

        NamingEnumeration answer = ctx.search("dc=example,dc=com", "(&(cn=*))", constraints);

        while (answer.hasMore()) {
            Attributes attrs = ((SearchResult) answer.next()).getAttributes();
            users.add(attrs.get("cn").toString().replace("cn:", ""));
        }

    } catch (Exception ex) {
    }
    return users;
}
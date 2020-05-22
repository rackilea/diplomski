// Create initial context
DirContext ctx = new InitialDirContext(env);

String searchBase = "ou=people";
SearchControls searchCtls = new SearchControls();

// Specify the search scope
searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

String uid = "5tey37";
String searchFilter = " (uid=" + uid + ") ";

NamingEnumeration<?> namingEnum = ctx.search(searchBase,searchFilter, searchCtls);
while (namingEnum.hasMore()) {
    SearchResult result = (SearchResult) namingEnum.next();
    // GET STUFF
    Attributes attrs = result.getAttributes();
    System.out.println(attrs.get("uid"));
...

}
namingEnum.close();
// Close the context when we're done
ctx.close();
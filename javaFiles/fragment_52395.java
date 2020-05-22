boolean endString = true;
int loopValue = 0;
while (endString) {
    int startValue = loopValue * 1000;
    int endvalue = (loopValue + 1) * 1000;
    SearchControls searchCtls = new SearchControls();
    String[] returnedAttrs = new String[1];
    String range = startValue + "-" + endvalue;
    returnedAttrs[0] = "member;range=" + range;
    searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
    searchCtls.setReturningAttributes(returnedAttrs);
    NamingEnumeration answer = ctx.search("", "(&(objectClass=group)(cn=testgroup))", searchCtls);
    while (answer.hasMore()) {
        SearchResult entry = (SearchResult) answer.next();
        System.out.println(entry.getAttributes());
        if (entry.getAttributes().toString().contains("{member;range=" + startValue + "-*")) {
            endString = false;
        }
    }
    loopValue++;
}
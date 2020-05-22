SearchControls controls = new SearchControls();
controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
NamingEnumeration<NameClassPair> list1 = iniDirContext.list(Constants.ORG_SEARCH_BASE);
while (list1.hasMore()) {
    String base = list1.next().getName() + "," + Constants.ORG_SEARCH_BASE; //no cast needed, list1 is strong typed
    SearchControls searchControls = new SearchControls();
    searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
    String filter = "(&(objectclass=groupOfUniqueNames))";
    NamingEnumeration<SearchResult> results1 = iniDirContext.search(base, filter, searchControls);
    while (results1.hasMore()) {
        SearchResult searchResult = results1.next();
        Attributes attributes = searchResult.getAttributes();
        Attribute cn = attributes.get(Constants.CN);
        Attribute address = attributes.get(Constants.POSTAL_ADDRESS);
        if (cn.get().equals(oranizationData.getOrgName()) && address.equals(oranizationData.getOrgAddress())) {
          return false;
        }
    }
}
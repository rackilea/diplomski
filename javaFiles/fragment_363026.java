NamingEnumeration<SearchResult> searchResults = ctx.search("DC=mydomain,DC=com", "(sAMAccountName=" + currentUser + ")", searchControls);

if (searchResults.hasMore()) {
  SearchResult currentSearchResult = searchResults.next();
  Attributes searchResultAttributes = currentSearchResult.getAttributes();

  String userID = searchResultAttributes.get("sAMAccountName");
  String lastName = searchResultAttributes.get("sn");
  String firstName = searchResultAttributes.get("givenName");
  String group = searchResultAttributes.get("memberOf");
  String jobTitle = searchResultAttributes.get("title");
  String phoneNumber = searchResultAttributes.get("telephoneNumber");
  String email = searchResultAttributes.get("mail");

  searchResults.close();
}

ctx.close();
com.unboundid.ldap.sdk.LDAPConnection connection = <some connection>

com.unboundid.ldap.sdk.SearchRequest request = new SearchRequest(<your parameters>);
request.setSizeLimit(<your limit>);

SearchResult result = connection.search(request);
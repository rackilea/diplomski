Hashtable<String, String> contextEnv = getContextEnv();

DirContext ctx = new InitialDirContext(contextEnv);    

// UserID - Last Name - First Name - Group - Job Title - Phone Number - Email address
String[] attrIDs = { "sAMAccountName", "sn", "givenName", "memberOf", "title", "telephoneNumber", "mail"};
SearchControls searchControls = new SearchControls();
searchControls.setReturningAttributes(attrIDs);
searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
searchControls.setTimeLimit(6000);
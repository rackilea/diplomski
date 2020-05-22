Query validuserquery = new Query("Users").
    setFilter(new Query.FilterPredicate("username", 
                  Query.FilterOperator.EQUAL,
                  usernamein)
    ).setKeysOnly();
Entity anyentity = datastore.prepare(validuserquery).asSingleEntity();
if(anyentity == null) {
    System.out.println("was not equal");
    return false;
}
return true;
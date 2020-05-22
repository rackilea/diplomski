SSOToken token = (SSOToken) AccessController.doPrivileged(AdminTokenAction.getInstance());
AMIdentityRepository ir = new AMIdentityRepository(token, "/");
IdSearchResults results = ir.searchIdentities(IdType.GROUP, "*", new IdSearchControl());
Set<AMIdentity> groups = results.getSearchResults();    
for (AMIdentity group : groups) {
    logger.debug("Group Name : " + group.getName());
}
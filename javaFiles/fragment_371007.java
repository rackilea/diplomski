String userid = "bob";//get from request
String uniqueid = "bob";

// stash in hashtable
Hashtable hashtable = new Hashtable();
hashtable.put(AttributeNameConstants.WSCREDENTIAL_UNIQUEID,uniqueid);
hashtable.put(AttributeNameConstants.WSCREDENTIAL_SECURITYNAME,userid);
// hashtable.put(AttributeNameConstants.WSCREDENTIAL_GROUPS,groups);
hashtable.put(AttributeNameConstants.WSCREDENTIAL_CACHE_KEY,uniqueid+"MyCustom");

Subject subject = new Subject();
subject.getPublicCredentials().add(hashtable);
return TAIResult.create(HttpServletResponse.SC_OK, "ignored", subject);
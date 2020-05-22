DirContextSource.Builder builder = new DirContextSource.Builder("ldap://hostname");
builder.gssApiAuth("MyAlternativeEntryName");
DirContextSource contextSource = builder.build();
// try and catch block omitted for the sake of brevity,
// handle NamingException appropriately
DirContext context = contextSource.getDirContext();
// Perform operations
context.close();
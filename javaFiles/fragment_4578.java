public class LdapAndDatabaseAuthoritiesPopulator extends DefaultLdapAuthoritiesPopulator{

  public LdapAndDatabaseAuthoritiesPopulator(ContextSource contextSource, String groupSearchBase) {
    super(contextSource, groupSearchBase);
  }

  protected Set<GrantedAuthority> getAdditionalRoles(DirContextOperations user,
      String username) {
    Set<GrantedAuthority> mappedAuthorities = new HashSet<GrantedAuthority>();

    /* Add additional roles from other sources for this user*/
    /* below add is just an example of how to add a role */
    mappedAuthorities.add(
        new GrantedAuthority() { 
          private static final long serialVersionUID = 3618700057662135367L;

          @Override 
          public String getAuthority() { 
            return "ROLE_MYAPP_USER"; //this is just a temporary role we are adding as example. get the roles from database.
          } 

         @Override
         public String toString(){
          return this.getAuthority();
         }
        });


    for (GrantedAuthority granted : mappedAuthorities) {
      log.debug("Authority : {}", granted.getAuthority().toString());
    }

    return mappedAuthorities;
  }

}
@Autowired
public ApplicationConfig app; 

public UserData getUser(@PathVariable String userid) {          
      DirContext context = connectToLdap();
      //some operations...
      appProp.getServerUrl();
      appProp.getAdminName();
      context.close();    
      return user;
}
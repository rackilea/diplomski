@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    // Load users file
    Resource confFile = resourceLoader.getResource("classpath:users.list");

    // Returns users from the configuration file <username, password (BCrypted), admin (boolean)>
    List<ApiUser> users = ApiUtils.getUsersFromFile(confFile);

    @SuppressWarnings("rawtypes")
    UserDetailsBuilder udb = null;

    for(ApiUser u : users){
        // Add the username/password to the in-memory authentication manager
        if (udb == null)
            udb = auth.inMemoryAuthentication().withUser(u.username).password(u.password);
        else
            udb = udb.and().withUser(u.username).password(u.password);

        if (u.admin)
            udb.roles("USER", "ADMIN");
        else
            udb.roles("USER");
    }
}
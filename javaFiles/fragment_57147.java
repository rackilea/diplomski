for(ApiUser u : users){
    // Add the username/password to the in-memory authentication manager
    if (u.admin)
        auth.inMemoryAuthentication().withUser(u.username).password(u.password).roles("USER", "ADMIN");
    else
        auth.inMemoryAuthentication().withUser(u.username).password(u.password).roles("USER");
}
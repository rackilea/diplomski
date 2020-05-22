@PropertySources({
        @PropertySource("/user.properties"),
        @PropertySource("/password.properties")
}). 
@Configuration
public configClass{
    @Value("{db.user}")
    private String user;
    @Value("{db.password}")
    private String password;
    ...
}
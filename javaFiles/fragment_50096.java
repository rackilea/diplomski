@Autowired
public void configureBothAuthentication(AuthenticationManagerBuilder auth) throws Exception
{
    auth.inMemoryAuthentication()
        .withUser("restapiuser")
        .password(new BCryptPasswordEncoder().encode("restapiuser@123#"))
        .roles("ADMIN");

    auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
            .usersByUsernameQuery("select username, password, enabled from userdetails where userName=?")
            .authoritiesByUsernameQuery(
                    "select ud.username as username, rm.name as role from userdetails ud INNER JOIN rolemaster rm ON rm.id = ud.roleId  where username = ?");
}
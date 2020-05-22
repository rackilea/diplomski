@Autowired
private ResourceServerProperties sso;

@Bean
public ResourceServerTokenServices userInfoTokenServices() {
    return new AdfsUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
}
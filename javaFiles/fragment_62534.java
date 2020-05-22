@EnableOAuth2Client
@RestController
@Configuration
public class WebSecurityConfigurator extends WebSecurityConfigurerAdapter {

 @Autowired
 OAuth2ClientContext oauth2ClientContext;

 @RequestMapping("/user")
 public Principal user(Principal principal) {
 return principal;
 }

 // @formatter:off
 @Override
 protected void configure(HttpSecurity http) throws Exception {
 http.antMatcher("/**")
 .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
 .authorizeRequests()
 .antMatchers("/", "/login**", "/webjars/**")
 .permitAll()
 .anyRequest()
 .authenticated()
 .and()
 .logout()
     .logoutSuccessUrl("/").permitAll().and().csrf()
 .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
 }
 // @formatter:on

 private Filter ssoFilter() {

 CompositeFilter filter = new CompositeFilter();
 List filters = new ArrayList<>();

 OAuth2ClientAuthenticationProcessingFilter googleFilterA = new OAuth2ClientAuthenticationProcessingFilter(
 "/login/googleA");
 OAuth2RestTemplate googleTemplateA = new OAuth2RestTemplate(googleA(), oauth2ClientContext);
 googleFilterA.setRestTemplate(googleTemplateA);
 tokenServices = new UserInfoTokenServices(googleResource().getUserInfoUri(), googleA().getClientId());
 tokenServices.setRestTemplate(googleTemplateA);
 googleFilterA.setTokenServices(tokenServices);

 OAuth2ClientAuthenticationProcessingFilter googleFilterB = new OAuth2ClientAuthenticationProcessingFilter(
 "/login/googleB");
 OAuth2RestTemplate googleTemplateB = new OAuth2RestTemplate(googleB(), oauth2ClientContext);
 googleFilterB.setRestTemplate(googleTemplateB);
 tokenServices = new UserInfoTokenServices(googleResource().getUserInfoUri(), googleB().getClientId());
 tokenServices.setRestTemplate(googleTemplateB);
 googleFilterB.setTokenServices(tokenServices);



 filters.add(googleFilterA);
 filters.add(googleFilterB);

 filter.setFilters(filters);

 return filter;
 }

 @Bean
 public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
 FilterRegistrationBean registration = new FilterRegistrationBean();
 registration.setFilter(filter);
 registration.setOrder(-100);
 return registration;
 }



 @Bean
 @ConfigurationProperties("google.clientA")
 public AuthorizationCodeResourceDetails googleA() {
 return new AuthorizationCodeResourceDetails();
 }

 @Bean
 @ConfigurationProperties("google.resource")
 public ResourceServerProperties googleResource() {
 return new ResourceServerProperties();
 }


 @Bean
 @ConfigurationProperties("google.clientB")
 public AuthorizationCodeResourceDetails googleB() {
 return new AuthorizationCodeResourceDetails();
 }
 }
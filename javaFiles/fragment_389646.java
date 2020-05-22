// ... imports 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, proxyTargetClass = true)
@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

  // Authentication manager configuration
  @Autowired
  private WindowsAuthenticationProviderWrapper authProvider;

  @Autowired
  private AuthenticationManagerBuilder auth;

  @Override
  protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProvider);
  }

  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    return auth.getObject();
  }

  // Waffle configuration
  @Bean
  public Filter customPreAuthSecurityFilter() {
    return new CustomPreAuthSecurityFilter();
  }

  @Bean
  public Filter customNegotiateSecurityFilter() {
    return new CustomNegotiateSecurityFilter();
  }

  @Bean
  public WindowsAuthProviderImpl waffleAuthProvider(){
    return new WindowsAuthProviderImpl();
  }

  @Bean(name="negotiateSecurityFilterProvider")
  @Autowired
  public NegotiateSecurityFilterProvider negotiateSecurityFilterProvider(){
    NegotiateSecurityFilterProvider bean = new NegotiateSecurityFilterProvider(waffleAuthProvider());
    List<String> protocols = new ArrayList<>();
    protocols.add("Negotiate");
    bean.setProtocols(protocols);
    return bean;
  }

  @Bean
  public BasicSecurityFilterProvider basicSecurityFilterProvider(){
    return new BasicSecurityFilterProvider(waffleAuthProvider());
  }

  @Bean(name="waffleSecurityFilterProviderCollection")
  @Autowired
  public waffle.servlet.spi.SecurityFilterProviderCollection negotiateSecurityFilterProviderCollection() {
    final List<SecurityFilterProvider> lsp = new ArrayList<>();
    lsp.add(negotiateSecurityFilterProvider());
    lsp.add(basicSecurityFilterProvider());
    return new waffle.servlet.spi.SecurityFilterProviderCollection(lsp.toArray(new SecurityFilterProvider[]{}));
  }

  @Bean(name="negotiateSecurityFilterEntryPoint")
  @Autowired
  public waffle.spring.NegotiateSecurityFilterEntryPoint negotiateSecurityFilterEntryPoint() {
    final waffle.spring.NegotiateSecurityFilterEntryPoint ep = new waffle.spring.NegotiateSecurityFilterEntryPoint();
    ep.setProvider(negotiateSecurityFilterProviderCollection());
    return ep;
  }

  @Bean(name="negotiateSecurityFilter")
  @Autowired
  public waffle.spring.NegotiateSecurityFilter waffleNegotiateSecurityFilter(){
    waffle.spring.NegotiateSecurityFilter bean = new waffle.spring.NegotiateSecurityFilter();
    bean.setRoleFormat("both");
    bean.setPrincipalFormat("fqn");
    bean.setAllowGuestLogin(false);
    bean.setProvider(negotiateSecurityFilterProviderCollection());
    return bean;
  }

  // Static Mappings
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/assets/**");
  }

  // Security filter chain
  // The custom filters can be removed if you only use waffle 
  // but this is how we added them
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // A user needs to have the role user and has to be authenticated
    http.exceptionHandling()
      .authenticationEntryPoint(negotiateSecurityFilterEntryPoint()).and()
      .addFilterBefore(customPreAuthSecurityFilter(), BasicAuthenticationFilter.class)
      .addFilterAfter(waffleNegotiateSecurityFilter(), BasicAuthenticationFilter.class)
      .addFilterAfter(customNegotiateSecurityFilter(), BasicAuthenticationFilter.class)
      .authorizeRequests().anyRequest().fullyAuthenticated();
     }
  }
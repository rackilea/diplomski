@Configuration
@EnableGlobalMethodSecurity
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

  @Inject
  private MessageSource messageSource;

  @Override
  protected AccessDecisionManager accessDecisionManager() {
    AffirmativeBased manager = (AffirmativeBased)super.accessDecisionManager();
    manager.setMessageSource(messageSource);
    return manager;
  }
}
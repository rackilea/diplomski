@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
      // ... create and return custom MethodSecurityExpressionHandler ...
      return expressionHandler;
  }
}
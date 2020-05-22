// resolves auditor from SecurityContext
public class AuditorAwareImpl implements AuditorAware<User> {

  @Override
  public User getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof WrappedUser) {
      WrappedUser principal = (WrappedUser)authentication.getPrincipal();
      return principal.getUser();
    }
    throw new IllegalStateException("No current auditor available!");
  }
}
public class SessionBasedDelegatingContextSource implements ContextSource {
  private Map<String, ContextSource> contextSources;

  @Required
  public void setContextSources(Map<String, ContextSource> contextSources) {
    this.contextSources = new HashMap<>(contextSources);
  }

  protected final ContextSource getSessionContextSource() {
    String id = (String) RequestContextHolder.currentRequestAttributes()
                 .getAttribute("currentContextSource", SCOPE_SESSION);

    if(id == null) {
      throw new IllegalStateException("No Ldap target selected");
    }

    ContextSource contextSource = contextSources.get(id);
    if(contextSource == null) {
      throw new IllegalArgumentException("No Ldap target selected");
    }

    return contextSource;
  }

  @Override
  public DirContext getReadOnlyContext() {
    getSessionContextSource().getReadOnlyContext();
  }

  @Override
  public DirContext getReadWriteContext() {
    getSessionContextSource().getReadWriteContext();
  }

  @Override
  public DirContext getContext(String principal, String credentials) {
    getSessionContextSource().getContext(principal, credentials);
  }
}
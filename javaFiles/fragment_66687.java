@Inject
private javax.inject.Provider<ISecurityContext> securityContextProvider;

@Override
public void filter(ContainerRequestContext context) throws IOException {
    ISecurityContext sc = securityContextProvider.get();
}

...
bindFactory(SecurityHandlerProvider.class)
          .to(ISecurityContext.class)
          .in(RequestScoped.class);
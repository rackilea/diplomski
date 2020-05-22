@Priority(Priorities.AUTHENTICATION)
public class JWTCredentialAuthFilter<P extends Principal> extends AuthFilter<JWTCredentials, P> {

  public static class Builder<P extends Principal>
      extends AuthFilterBuilder<JWTCredentials, P, JWTCredentialAuthFilter<P>> {

    @Override
    protected JWTCredentialAuthFilter<P> newInstance() {
      return new JWTCredentialAuthFilter<>();
    }
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    final JWTCredentials credentials =
    getCredentials(requestContext.getHeaders().getFirst(HttpHeaders.AUTHORIZATION));
    if (!authenticate(requestContext, credentials, "JWT")) {
      throw new WebApplicationException(
          this.unauthorizedHandler.buildResponse(this.prefix, this.realm));
    }
  }

  private static JWTCredentials getCredentials(String authLine) {
    if (authLine != null && authLine.startsWith("Bearer ")) {
      JWTCredentials result = new JWTCredentials();
      result.setJwtToken(authLine.substring(7));
      return result;
    }
    return null;
  }
}
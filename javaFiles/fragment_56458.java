public class JWTAuthenticator implements Authenticator<JWTCredentials, User> {

  private String secret;

  public JWTAuthenticator(String jwtsecret) {
    this.secret = jwtsecret;
  }

  @Override
  public Optional<User> authenticate(JWTCredentials credentials) throws AuthenticationException {
    try {
      Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(this.secret))
      .parseClaimsJws(credentials.getJwtToken()).getBody();
      User user = new User();
      user.setName(claims.getSubject());
      return Optional.ofNullable(user);
    } catch (@SuppressWarnings("unused") ExpiredJwtException | UnsupportedJwtException
        | MalformedJwtException | SignatureException | IllegalArgumentException e) {
      return Optional.empty();
    }
  }
}
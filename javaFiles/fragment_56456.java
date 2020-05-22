@POST
@Path("{user}")
@PermitAll
public String createToken(@PathParam("user") String user, String password) {
  if ("test".equals(user) && "test".equals(password)) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(this.secretKey);
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    JwtBuilder builder = Jwts.builder().setIssuedAt(now).setSubject("test")
      .signWith(signatureAlgorithm, signingKey);
    return builder.compact();
  }
  throw new WebApplicationException(Response.Status.UNAUTHORIZED);
}
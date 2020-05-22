Date expiration = getExpirationDate(); // implement me

Jwts.builder().setSubject("Joe")
    .setExpiration(expiration)
    .signWith(SignatureAlgorithm.HS512, key)
    .compact();
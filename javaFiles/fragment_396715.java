Map<String, Object> claims = ImmutableMap.of("admin", "true");

String jws = Jwts.builder()
        .setIssuer("mycompany")
        .setExpiration(Date.from(OffsetDateTime.now().plus(60, DAYS).toInstant()))
        .addClaims(claims) // See the notes below
        .signWith(key)
        .compact();

Jws<Claims> jwsClaims = Jwts.parser()
        .requireIssuer("mycompany")
        .require("admin", "true")
        .setSigningKey(key)
        .parseClaimsJws(jws);
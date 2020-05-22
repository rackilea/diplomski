String jws = Jwts.builder()
        .setIssuer("mycompany")
        .setExpiration(Date.from(OffsetDateTime.now().plus(60, DAYS).toInstant()))
        .claim("admin", "true")
        .signWith(key)
        .compact();

Jws<Claims> jwsClaims = Jwts.parser()
        .requireIssuer("mycompany")
        .require("admin", "true")
        .setSigningKey(key)
        .parseClaimsJws(jws);
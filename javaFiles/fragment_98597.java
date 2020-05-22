public class JwtFactory {

    private Map<String, Key> keys = new HashMap<>();

    public JwtFactory(String keyStore, String keyStorePassword, Map<String, String> resourcesPassword) {
        try {
            KeyStore keystore = KeyStore.getInstance("PKCS12");
            try (InputStream is = Files.newInputStream(Paths.get("jwt.pkcs12"))) {
                keystore.load(is, keyStorePassword.toCharArray());
            }
            for (Map.Entry<String, String> resource : resourcesPassword.entrySet()) {
                keys.put(resource.getKey(), keystore.getKey(resource.getKey(), resource.getValue().toCharArray()));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to load key", e);
        }
    }

    public String createToken(String resourceId, String subject, String id, Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(subject)
                .setId(id)
                .setIssuedAt(Date.from(Instant.ofEpochSecond(System.currentTimeMillis() - 3600)))
                .setExpiration(Date.from(Instant.ofEpochSecond(System.currentTimeMillis() + 3600)))
                .addClaims(claims)
                .signWith(SignatureAlgorithm.RS256, keys.get(resourceId))
                .compact();
    }

    public static void main(String[] args) throws Exception {
        final Map<String, String> resources = new HashMap<>();
        resources.put("resource1", "password");
        resources.put("resource2", "password");

        final Map<String, Object> claims = new HashMap<>();
        claims.put("name", "John Doe");
        claims.put("admin", true);


        JwtFactory factory = new JwtFactory("jwt.pkcs12", "password", resources);
        String token1 = factory.createToken("resource1", "1234567890", "a8070da2-3497-4a51-a932-daa9ae53bddd", claims);
        String token2 = factory.createToken("resource2", "1234567890", "a8070da2-3497-4a51-a932-daa9ae53bddd", claims);

        System.out.println(token1);
        System.out.println(token2);

        final String resource1Public = new String(Files.readAllBytes(Paths.get("resource1.pem")), StandardCharsets.ISO_8859_1)
            .replaceAll("-----BEGIN PUBLIC KEY-----\n", "")
            .replaceAll("-----END PUBLIC KEY-----", "");

        final X509EncodedKeySpec specKey1 = new X509EncodedKeySpec(Base64.decodeBase64(resource1Public.getBytes(StandardCharsets.ISO_8859_1)));

        Jwt jwt = Jwts.parser().setSigningKey(KeyFactory.getInstance("RSA").generatePublic(specKey1)).parse(token1);
        System.out.println("Validation Ok with resource 1");
        System.out.println(jwt);
        try {
            Jwts.parser().setSigningKey(KeyFactory.getInstance("RSA").generatePublic(specKey1)).parse(token2);
        } catch (Exception e) {
            System.out.println("Validation fail with resource 2");
        }
    }
}
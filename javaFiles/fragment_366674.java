String payload = "The quick brown fox jumps over the lazy dog";

//JJWT
String jwtJJWT = Jwts.builder().setPayload(payload).signWith(io.jsonwebtoken.SignatureAlgorithm.ES256, privateKey).compact();

//CXF
JwsCompactProducer compactProducer = new JwsCompactProducer(payload);
compactProducer.getJwsHeaders().setSignatureAlgorithm(SignatureAlgorithm.ES256);
String jwtCXF = compactProducer.signWith(privateKey);
String signatureCXF = compactProducer.getEncodedSignature(); // signature, 3. portion of JWT
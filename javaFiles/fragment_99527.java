String token = eyJ....;
String[] splitToken = JWTEncoded.split("\\.");

// splitToken[0] is the header, splitToken[1] is the payload and
// splitToken[2] is the signature
byte[] decodedBytes = Base64.decode(splitToken[1], Base64.URL_SAFE);

// You don't have to convert it to string but it really depends on what type
// data you expect
String payload = new String(decodedBytes, "UTF-8");
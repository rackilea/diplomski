// CREATE NEW KEY
// GET ENCODED VERSION OF KEY (THIS CAN BE STORED IN A DB)

    SecretKey secretKey;
    String stringKey;

    try {secretKey = KeyGenerator.getInstance("AES").generateKey();}
    catch (NoSuchAlgorithmException e) {/* LOG YOUR EXCEPTION */}

    if (secretKey != null) {stringKey = Base64.encodeToString(secretKey.getEncoded(), Base64.DEFAULT)}
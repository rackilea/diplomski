public static Optional<RSAPublicKey> getParsedPublicKey(){
       // public key content...excluding '---PUBLIC KEY---' and '---END PUBLIC KEY---'
        String PUB_KEY =System.getenv("PUBLIC_KEY") ; 

       // removes white spaces or char 20
        String PUBLIC_KEY = "";
          if (!PUB_KEY.isEmpty()) {
            PUBLIC_KEY = PUB_KEY.replace(" ", "");
        }

        try {
            byte[] decode = com.google.api.client.util.Base64.decodeBase64(PUBLIC_KEY);
            X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(decode);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(keySpecX509);
            return Optional.of(pubKey);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            System.out.println("Exception block | Public key parsing error ");
            return Optional.empty();
        }
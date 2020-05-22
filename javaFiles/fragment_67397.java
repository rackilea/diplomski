public class HMACKeyStore {
    public static void gen( String thePath, String thePassword ) throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA256");
        SecretKey key = keygen.generateKey();

        KeyStore keystore = KeyStore.getInstance("jceks");
        keystore.load(null, null);

        // This call throws an exception
        keystore.setKeyEntry("theKey", key, thePassword.toCharArray(), null);
        keystore.store( new FileOutputStream(thePath), thePassword.toCharArray() );

        SecretKey keyRetrieved = (SecretKey) keystore.getKey("theKey", thePassword.toCharArray());
        System.out.println(keyRetrieved.getAlgorithm());
    }

    public static void main(String[] args) throws Exception {
        gen("hmac_store.jceks", "password");
    }
}
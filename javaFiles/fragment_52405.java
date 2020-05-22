public class KeyTest{
static final String ALGORITHM           = "RSA";
static final int    KEYSIZE             = 1024;

static final String SIGNATURE_ALGORITHM = "SHA512withRSA";

static final String PUBLICKEY_PREFIX    = "-----BEGIN PUBLIC KEY-----";
static final String PUBLICKEY_POSTFIX   = "-----END PUBLIC KEY-----";
static final String PRIVATEKEY_PREFIX   = "-----BEGIN RSA PRIVATE KEY-----";
static final String PRIVATEKEY_POSTFIX  = "-----END RSA PRIVATE KEY-----";

public static void main(String args[]) {
    try {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(KEYSIZE);

        KeyPair keyPair = keyPairGenerator.genKeyPair();

        // THIS IS java.security

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("Public java.security: Algorithm: " + publicKey.getAlgorithm() + "Format: " + publicKey.getFormat());
        System.out.println("Private java.security: Algorithm: " + privateKey.getAlgorithm() + "Format: " + privateKey.getFormat() + "\n");

        // THIS IS DER:

        byte[] publicKeyDER = publicKey.getEncoded();
        byte[] privateKeyDER = privateKey.getEncoded();

        System.out.println("Public DER: "+Arrays.toString(publicKeyDER));
        System.out.println("Private DER: "+Arrays.toString(privateKeyDER) + "\n");

        // THIS IS PEM:

        String publicKeyPEM = PUBLICKEY_PREFIX + "\n" + DatatypeConverter.printBase64Binary(publicKey.getEncoded()).replaceAll("(.{64})", "$1\n") + "\n" + PUBLICKEY_POSTFIX;
        String privateKeyPEM = PRIVATEKEY_PREFIX + "\n" + DatatypeConverter.printBase64Binary(privateKey.getEncoded()).replaceAll("(.{64})", "$1\n") + "\n" + PRIVATEKEY_POSTFIX;

        System.out.println("Public PEM: " + "\n"+publicKeyPEM);
        System.out.println("Private PEM: " + "\n"+privateKeyPEM + "\n");

        // Signing the teststring
        String message = "Lorem ipsum dolor sit amet";

        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initSign(privateKey);
        sig.update(message.getBytes());

        byte[] signatureByteArray = sig.sign();

        String signature = "-----BEGIN SIGNATURE-----" + "\n"
                    + DatatypeConverter.printBase64Binary(signatureByteArray).replaceAll("(.{64})", "$1\n") + "\n"
                    + "-----END SIGNATURE-----";

        System.out.println("Message Plaintext: " + message);
        System.out.println("Signature: " + "\n" + signature + "\n");
    } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
}
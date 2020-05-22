public class CsrHelper {

  private final static String DEFAULT_SIGNATURE_ALGORITHM = "SHA256withRSA";
  private final static String CN_PATTERN = "CN=%s, O=Aralink, OU=OrgUnit";

  private static class JCESigner implements ContentSigner {

        private static Map<String, AlgorithmIdentifier> ALGOS = new HashMap<String, AlgorithmIdentifier>();

        static {
            ALGOS.put("SHA256withRSA".toLowerCase(), new AlgorithmIdentifier(
                    new ASN1ObjectIdentifier("1.2.840.113549.1.1.11")));
            ALGOS.put("SHA1withRSA".toLowerCase(), new AlgorithmIdentifier(
                    new ASN1ObjectIdentifier("1.2.840.113549.1.1.5")));

        }

        private String mAlgo;
        private Signature signature;
        private ByteArrayOutputStream outputStream;

        public JCESigner(PrivateKey privateKey, String sigAlgo) {
            //Utils.throwIfNull(privateKey, sigAlgo);
            mAlgo = sigAlgo.toLowerCase();
            try {
                this.outputStream = new ByteArrayOutputStream();
                this.signature = Signature.getInstance(sigAlgo);
                this.signature.initSign(privateKey);
            } catch (GeneralSecurityException gse) {
                throw new IllegalArgumentException(gse.getMessage());
            }
        }

        @Override
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            AlgorithmIdentifier id = ALGOS.get(mAlgo);
            if (id == null) {
                throw new IllegalArgumentException("Does not support algo: " +
                        mAlgo);
            }
            return id;
        }

        @Override
        public OutputStream getOutputStream() {
            return outputStream;
        }

        @Override
        public byte[] getSignature() {
            try {
                signature.update(outputStream.toByteArray());
                return signature.sign();
            } catch (GeneralSecurityException gse) {
                gse.printStackTrace();
                return null;
            }
        }
    }

//Create the certificate signing request (CSR) from private and public keys
public static PKCS10CertificationRequest generateCSR(KeyPair keyPair, String cn) throws IOException,
            OperatorCreationException {
        String principal = String.format(CN_PATTERN, cn);

        ContentSigner signer = new JCESigner (keyPair.getPrivate(),DEFAULT_SIGNATURE_ALGORITHM);

        PKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(
                new X500Name(principal), keyPair.getPublic());
        ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
        extensionsGenerator.addExtension(Extension.basicConstraints, true, new BasicConstraints(
                true));
        csrBuilder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest,
                extensionsGenerator.generate());
        PKCS10CertificationRequest csr = csrBuilder.build(signer);

        return csr;
    }
}
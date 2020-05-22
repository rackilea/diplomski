String encodedCert = "MIIBRjCB7KADAgECAgYBaqxRCjswDAYIKoZIzj0EAwIFADApMQswCQYDVQQGEwJDQTEMMAoGA1UE\n" +
            "ChMDbWVoMQwwCgYDVQQDEwNtZWgwHhcNMTkwNTEyMTM1MjMzWhcNMjAwNTExMTM1MjMzWjApMQsw\n" +
            "CQYDVQQGEwJDQTEMMAoGA1UEChMDbWVoMQwwCgYDVQQDEwNtZWgwWTATBgcqhkjOPQIBBggqhkjO\n" +
            "PQMBBwNCAAQH83AhYHCehKj7M5+UTNshwLFqqqJWGrJPNj9Kr7xvxtcZnyjq+AKLGMLfdk/G7yb8\n" +
            "4vIh0cJwtVs70WgIXT8xMAwGCCqGSM49BAMCBQADRwAwRAIgO0PJRzan2msHpcvcqhybzeualDea\n" +
            "/X2QGAWCYT+sNiwCIDMrfhrzUQ6uIX4vnB8AYqb85Ssl7Qcl9nYtjHb08NR8";

    X509Util x509Util = new X509Util();
    X509Certificate x509Certificate = x509Util.fromBase64Der(encodedCert);

    // the JWE object
    JsonWebEncryption jwe = new JsonWebEncryption();

    // The output of the ECDH-ES key agreement will be used as the content encryption key
    jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.ECDH_ES);

    // The content encryption key is used to encrypt the payload
    // with a composite AES-CBC / HMAC SHA2 encryption algorithm
    jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);

    // don't think you really need this but you had ""apv":DirectoryServerID" in the question so...
    jwe.setHeader(HeaderParameterNames.AGREEMENT_PARTY_V_INFO, Base64Url.encodeUtf8ByteRepresentation("<<DirectoryServerID>>"));

    // We encrypt to the receiver using their public key
    jwe.setKey(x509Certificate.getPublicKey());

    // and maybe put x5t to help the receiver know which key to use in decryption
    jwe.setX509CertSha1ThumbprintHeaderValue(x509Certificate);

    // What is going to be encrypted
    jwe.setPayload("Your text here. It can be JSON or whatever.");

    // Produce the JWE compact serialization, which is a string consisting of five dot ('.') separated
    // base64url-encoded parts in the form Header..IV.Ciphertext.AuthenticationTag
    String serializedJwe = jwe.getCompactSerialization();

    System.out.println(serializedJwe);
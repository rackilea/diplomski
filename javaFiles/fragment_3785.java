@ApiMethod(name = "getUploadUrl", path = "getuploadurl", httpMethod = HttpMethod.GET)
public MyApiResponse getUploadUrl(@Named("fileName") String fileName
                                  @Named("contentType" String contentType)
{
        String stringToSign
            = "PUT\n" + contentType
            + "\n" + EXPIRATION_TIMESTAMP_EPOCH_SECONDS + "\n"
            + YOUR_GCS_BUCKET + "/" + fileName;

        // Load P12 key
        FileInputStream fileInputStream = new FileInputStream(PATH_TO_P12_KEY);
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(fileInputStream, password);
        PrivateKey key = keyStore.getKey(privatekey", YOUR_P12_KEY_PASSWORD);

        // Get signature
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initSign(key);
        signer.update(stringToSign.getBytes("UTF-8"));
        byte[] rawSignature = signer.sign();
        String signature = new String(Base64.encodeBase64(rawSignature, false), "UTF-8");

        // Construct signed url
        String url
            = "http://storage.googleapis.com/" + YOUR_GCS_BUCKET + fileName
            + "?GoogleAccessId=" + P12_KEY_SERVICE_ACCOUNT_CLIENT_ID
            + "&Expires=" + EXPIRATION_TIMESTAMP_EPOCH_SECONDS
            + "&Signature=" + URLEncoder.encode(signature, "UTF-8");

        // Endpoints doesn't let you return 'String' directly
        MyApiResponse response = new MyApiResponse();
        response.setString(url);
        return response;
}
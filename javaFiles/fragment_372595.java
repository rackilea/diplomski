public static String getHexEncodedPublicKey(PublicKey publicKey) throws IOException, InvalidKeyException {
    ECPublicKeyParameters ecPublicKeyParameters
            = (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(publicKey);
    byte[] encoded = ecPublicKeyParameters.getQ().getEncoded(false);
    return Hex.toHexString(encoded);
}
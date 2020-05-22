/**
 * This method converts the EC public key (ECPublicKey#getW()) into ECPublicKey
 * @param cardPublicKey as W
 * @param curveName (for example "P-224")
 * @return java.security.interfaces.ECPublicKey
 */
public ECPublicKey ucPublicKeyToPublicKey(byte[] cardPublicKey, String curveName) {
    //for example curveName = "P-224";
    java.security.interfaces.ECPublicKey ecPublicKey = null; // java.security.interfaces.ECPublicKey
    java.security.KeyFactory kf = null;

    org.bouncycastle.jce.spec.ECNamedCurveParameterSpec ecNamedCurveParameterSpec = ECNamedCurveTable.getParameterSpec(curveName);
    org.bouncycastle.math.ec.ECCurve curve = ecNamedCurveParameterSpec.getCurve();
    java.security.spec.EllipticCurve ellipticCurve = EC5Util.convertCurve(curve, ecNamedCurveParameterSpec.getSeed());
    java.security.spec.ECPoint ecPoint = ECPointUtil.decodePoint(ellipticCurve, cardPublicKey);
    java.security.spec.ECParameterSpec ecParameterSpec = EC5Util.convertSpec(ellipticCurve, ecNamedCurveParameterSpec);
    java.security.spec.ECPublicKeySpec publicKeySpec = new java.security.spec.ECPublicKeySpec(ecPoint, ecParameterSpec);

    try {
        kf = java.security.KeyFactory.getInstance("EC", "BC");
    } catch (Exception e) {
        System.out.println("Caught Exception kf : " + e.toString());
    }

    try {
        ecPublicKey = (ECPublicKey) kf.generatePublic(publicKeySpec);
    } catch (Exception e) {
        System.out.println("Caught Exception public key: " + e.toString());
    }

    return ecPublicKey;
}
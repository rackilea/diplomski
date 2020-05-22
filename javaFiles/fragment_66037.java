private byte[] getSignedParams(ChannelBuffer params)
        throws NoSuchAlgorithmException, DigestException, 
        SignatureException, InvalidKeyException {
    byte[] signedParams = null;
    Signature signature = Signature.getInstance(selectedSignAndHash.toString());
    ChannelBuffer signAlg = ChannelBuffers.buffer(2);
    signAlg.writeByte(selectedSignAndHash.hash.value);
    signature.initSign(privateKey);

    signature.update(clientRandom);
    signature.update(serverRandom);
    signature.update(params.toByteBuffer());

    signedParams = signature.sign();

    signAlg.writeByte(session.cipherSuite.sign.value);
    ChannelBuffer signLength = ChannelBuffers.buffer(2);
    signLength.writeShort(signedParams.length);
    return concat(signAlg.array(), concat(signLength.array(), signedParams));
}
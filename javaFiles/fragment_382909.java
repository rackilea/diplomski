// Add signature to request
    SignatureBuilder signFactory = new SignatureBuilder();
    Signature signature = signFactory.buildObject(Signature.DEFAULT_ELEMENT_NAME);
            signature.setCanonicalizationAlgorithm(getIdpSignature().getCanonicalizationAlgorithm());
            signature.setSignatureAlgorithm(getIdpSignature().getSignatureAlgorithm());
            signature.setSigningCredential(this.getCredentialFromFiles(SP_PRIVATEKEY,SP_CERTIFICATE));
// set signature
request.setSignature(signature);
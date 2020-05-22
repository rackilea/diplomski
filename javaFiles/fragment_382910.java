private void signRequest(SignableXMLObject obj) {
        Credential credential = this.getCredential(SP_PRIVATEKEY, SP_CERTIFICATE);
        Signature signature = (Signature) Configuration.getBuilderFactory().getBuilder(Signature.DEFAULT_ELEMENT_NAME)
                .buildObject(Signature.DEFAULT_ELEMENT_NAME);
        signature.setSigningCredential(credential);
        signature.setCanonicalizationAlgorithm(getIdpSignature().getCanonicalizationAlgorithm());
        signature.setSignatureAlgorithm(getIdpSignature().getSignatureAlgorithm());
        SecurityConfiguration secConfig = Configuration.getGlobalSecurityConfiguration();
        try {
            SecurityHelper.prepareSignatureParams(signature, credential, secConfig, null);
            obj.setSignature(signature);
            Configuration.getMarshallerFactory().getMarshaller(obj).marshall(obj);
            Signer.signObject(signature);
        } catch (Exception e) {

        }
    }
KeyStore keyStore = KeyStore.getInstance(storeType, provider);
LoadStoreParameter param = new LoadStoreParameter() {
    @Override
    public ProtectionParameter getProtectionParameter() {
        return new KeyStore.CallbackHandlerProtection(... put your callback handler here...);
    }
};
keyStore.load(param);
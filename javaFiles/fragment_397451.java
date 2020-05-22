AddressingFeature feature = new AddressingFeature(true, false);
    port = service.getArkivServiceBasisEP(feature);

    objectFactory = new ObjectFactory();
    datatypeFactory = DatatypeFactory.newInstance();

    List<CredentialProvider> credProviders = new ArrayList<CredentialProvider>(); 
    CredentialProvider  cp = new ClientUNTCredentialProvider(username.getBytes(), password.getBytes()); 
    credProviders.add(cp); 

    Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
    requestContext.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credProviders);
    requestContext.put(WSSecurityContext.TRUST_MANAGER, new TrustManager() {
        public boolean certificateCallback(X509Certificate[] chain, int validateErr) {return true;}
    });
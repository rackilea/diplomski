// initializes the various security configurations
GlobalSecurityConfigurationInitializer.init();

// fetches the various security configurations
DecryptionConfiguration dc = SecurityConfigurationSupport.getGlobalDecryptionConfiguration();
EncryptionConfiguration ec = SecurityConfigurationSupport.getGlobalEncryptionConfiguration();
SignatureSigningConfiguration ssc = SecurityConfigurationSupport.getGlobalSignatureSigningConfiguration();
SignatureValidationConfiguration svc = SecurityConfigurationSupport.getGlobalSignatureValidationConfiguration();
/**
   * Creates a new crypto key with the given id.
   */
  public static CryptoKey createCryptoKey(String projectId, String locationId, String keyRingId,
      String cryptoKeyId)
      throws IOException {

    // Create the Cloud KMS client.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // The resource name of the location associated with the KeyRing.
      String parent = KeyRingName.format(projectId, locationId, keyRingId);
      ProtectionLevel protectionLevel = ProtectionLevel.HSM;

      // creating the template with the right protection level
      CryptoKeyVersionTemplate template = CryptoKeyVersionTemplate.newBuilder()
            .setProtectionLevel(protectionLevel)
            .build();

      // This will allow the API access to the key for encryption and decryption and also the HSM PL.
      CryptoKey cryptoKey = CryptoKey.newBuilder()
          .setPurpose(CryptoKeyPurpose.ENCRYPT_DECRYPT)
          .setVersionTemplate(template)
          .build();

      // Create the CryptoKey for your project.
      CryptoKey createdKey = client.createCryptoKey(parent, cryptoKeyId, cryptoKey);

      return createdKey;
    }
  }
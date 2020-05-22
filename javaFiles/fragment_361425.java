final String key2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDdQudusozLmogBfU2LCO+WcM59"
    + "ycup9SxMsBNCku23PxrPMO6u//QjtWPz7istE9vkQfa6tQn1Or+SDxeHLMxEesF0"
    + "xiBEgFUhg7vjOF2SnFQQEADgUyizUIBBn1UgKNA8eP24Ux0P0M2aHMn78HIHsRcu"
    + "pNGUNW7p51HOVoIPJQIDAQAB";

PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(
    new X509EncodedKeySpec(DatatypeConverter.parseBase64Binary(key2)));
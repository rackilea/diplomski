@Test
public void testKey() throws Exception {
    String privKeyStr = "MIICXQIBAAKBgQCE3pA746UfpC8sFk8ZJp0yupyJqj5jy6cjdxUYoP7mCm7c0mqQDeCcDNBYW2eSozCioPrH/9L+CDQEPLYakoem+jFnUKDH5+pru/0PJTJJF8Xh/ZT9eJlvsYBr1/qSfICf6RTs7kzwq9IuSZBw7/tfNEF9i0A8FVox6HOopXod1QIDAQABAoGANOFrYBqK5lvu1koOswDWQZFZqcSSzh8IZyoGwGWa7S0r0EECXlDXmuPSq8e9IfRG8ALHrH+ZlrbnFOSgyVSWHfpj3aH+qknoSX5TW2rMQHih8865xuqheMQ+RTZ7+BRDqNsYkzxB/Z8mqzpoJQSYf+H7nWxdDCgAJVYZzxl3DmUCQQD32iEjnwiwUjii8slcmvCEZl+z84DWNdvJOg6Z38sI4AvrfpKc1WAcDg1rNZCKrRgokh54wpLt08cpFcrD04c3AkEAiTzDmc0bdgfg5wj6xHFZpYlBwiGm/bjOR2PS57P0GNU5PsDllRbFqIuzArITutO5lvZZImzuYz7Lf+cQ73pxUwJBAOdEwmdaneDo17A0m2+to3/nhqWDMVSwLMU3RyiNigZeCMFU+bkd4PBMrHi9IoJDwacZsRU9eZwxYEUV8H2Jg0ECQEEkOqRSm2pXKwX/WSjNtQPCNxhy6NUeV6vDUmTxIjh3XYjP/ynZeVEbnoj1BjB0N2/U11Jj6nPpZqb7gyppMEkCQQCoGdVYDipU+hMMnvxa0zOIyQc/a+HE0lESqn+2ZPafYi9Z1RldRMvUXhP8U7s+OuhRwprdw2ivvOFrnWyz9lL2";
    byte[] data = Base64.getDecoder().decode(privKeyStr);

    /* Add PKCS#8 formatting */
    ASN1EncodableVector v = new ASN1EncodableVector();
    v.add(new ASN1Integer(0));
    ASN1EncodableVector v2 = new ASN1EncodableVector();
    v2.add(new ASN1ObjectIdentifier(PKCSObjectIdentifiers.rsaEncryption.getId()));
    v2.add(DERNull.INSTANCE);
    v.add(new DERSequence(v2));
    v.add(new DEROctetString(data));
    ASN1Sequence seq = new DERSequence(v);
    byte[] privKey = seq.getEncoded("DER");

    PKCS8EncodedKeySpec spec = new  PKCS8EncodedKeySpec(privKey);
    KeyFactory fact = KeyFactory.getInstance("RSA");
    PrivateKey key = fact.generatePrivate(spec);
    Assert.assertNotNull("Failed to generate the private key", key);
}
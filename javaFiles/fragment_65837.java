@Test
public void testThatEncryptingStringResultsInExpectedBytes() {
    byte[] encryption = enigma.encryptString(TEST_STRING);

    assertArrayEquals(EXPECTED_ENCRYPTION, encryption);
}

@Test
public void testThatDecryptinEncryptionResultsInOriginalString() {
    String decryption = enigma.decryptBytes(TEST_ENCRYPTION);

    assertEquals(EXPECTED_ORIGINAL_STRING, decryption);
}

@Test
public void testThatDecriptionReversesEncryption() {
    String decryption = enigma.decryptBytes(enigma.encryptString(TEST_STRING));

    assertEquals(TEST_STRING, decryption);
}

@Test
public void testThatEncryptionReversesDecryption() {
    byte[] encryption = enigma.encriptString(enigma.decryptBytes(TEST_ENCRYPTION));

    assertEquals(TEST_ENCRYPTION, encryption);
}
outputLen += c.doFinal(cipherText, outputLen);
if (outputLen == cipherText.length) {
    decrypted = new String(cipherText,"UTF8");
} else {
    byte[] truncatedOutput = new byte[outputLen];
    System.arraycopy(
            cipherText, 0,
            truncatedOutput, 0,
            outputLen 
        );
    decrypted = new String(truncatedOutput,"UTF8");
}
// decode
for (int i = 0; i < cipherBytes.length; i++) {

    plainBytes[i] = (byte) (cipherBytes[i] ^ keyBytes[i
            % keyBytes.length]);
}
plainText = new String(plainBytes, charSet); // <= make sure same charset both ends
System.out.println(plainText);
char[] cipher = "dstuvwxuzabcdefghiklmnopqr".toCharArray();

String plainText = "iloveyouz";

StringBuilder cipherText = new StringBuilder();
for (int i = 0; i < plainText.length(); i++) {
    cipherText.append(cipher[plainText.charAt(i) - 'a']);
}

System.out.println("Encrypted : " + cipherText.toString());

char[] original = new char[cipher.length];
for (int j = 0; j < original.length; j++) {
    original[cipher[j] - 'a'] = (char) ('a' + j);
}

StringBuilder decryption = new StringBuilder();

for (int i = 0; i < plainText.length(); i++) {
    decryption.append(original[cipherText.charAt(i) - 'a']);
}

System.out.println("Decrypted : " + decryption.toString());
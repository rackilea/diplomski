public static String encrypt(String plainText, String encKey) {
    StringBuilder encryptedText = new StringBuilder();
    char[] encArray = encKey.toCharArray();
    int encArrayLen = encArray.length;
    int cnt = 0;
    for (int i = 0; i < plainText.length(); i++) {
        if (plainText.charAt(i) != ' ') {
            char c = (char) (plainText.charAt(i) + (encArray[cnt] - 'a'));
            encryptedText.append(c);
        } else {
            encryptedText.append(plainText.charAt(i));
            cnt=cnt-1;
        }
        cnt++;
        if (cnt == encArrayLen) {
            cnt = 0;
        }
    }
    return encryptedText.toString();
}
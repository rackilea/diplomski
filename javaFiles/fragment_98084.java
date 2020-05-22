static String cipher(String msg, int shift){
    String characters = "01234556789ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    int n = characters.length();
    StringBuilder decryptedMessage = new StringBuilder();
    for (int x = 0; x < msg.length(); x++) {
        char ch = msg.charAt(x);
        int y = characters.indexOf(ch);
        if (y != -1) {
            int trueShift = (y + shift + n) % n;
            ch = characters.charAt(trueShift);
        }
        decryptedMessage.append(ch);
    }
    return decryptedMessage.toString();
}
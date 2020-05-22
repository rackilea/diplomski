// Untested code
// The code below need to be adjusted for it to print meaningful 
// characters in the encrypted string as the xor function produces
// integers outside the range of standard ascii characters 

private void cbcCaesar(){

    int key = 1;
    String message = "java";
    int initialisationVector = 5; // the IV is not super necessarily hidden from an attacker but should be different for each message

    StringBuilder encryptedMessageBuilder = new StringBuilder();

    char[] charArray = message.toCharArray();

    int encryptedLetter = initialisationVector;
    for (int letter : charArray){
        int xorApplied = letter ^ encryptedLetter;
        encryptedLetter = applyCaesarCipher(xorApplied, key);
        encryptedMessageBuilder.append((char) encryptedLetter);
    }

    System.out.println(encryptedMessageBuilder.toString());
}

private int applyCaesarCipher(int xorApplied, int key) {
    return (xorApplied+ key) % 26;
}
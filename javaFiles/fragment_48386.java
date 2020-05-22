public static char move13(char letter) {
    if (letter >= 'a' && letter <= 'm')
        return (char) (letter + 13);
    if (letter >= 'A' && letter <= 'M')
        return (char) (letter + 13);
    if (letter >= 'n' && letter <= 'z')
        return (char) (letter - 13);
    if (letter >= 'N' && letter <= 'Z')
        return (char) (letter - 13);
    return letter;
}

public static String encode(String text) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        char character = text.charAt(i);
        character = move13(character);
        sb.append(character);
        //System.out.println(valueOfchar);

    }
    return sb.toString();

}
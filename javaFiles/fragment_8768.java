public static String runLengthEncoding(String text) {
    String encodedString = "";

    for (int i = 0, count = 1; i < text.length(); i++) {
        if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1))
            count++;
        else {
            encodedString = encodedString.concat(Character.toString(text.charAt(i)));
            if(count>1) {
                encodedString = encodedString.concat(Integer.toString(count));
            }
            count = 1;
        }
    }
    return encodedString;
}
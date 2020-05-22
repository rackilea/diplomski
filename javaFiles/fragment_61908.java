public static String justAlphaChars(String text) {

    StringBuilder builder = new StringBuilder();

    for (char ch : text.toCharArray()) 
        if (Character.isAlphabetic(ch)) 
            builder.append(ch);

    return builder.toString();
}
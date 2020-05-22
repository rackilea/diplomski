public static String toggleStringJava8(String sentence) {
    return sentence.chars().mapToObj(c -> {
        if (Character.isUpperCase(c)) {
            c = Character.toLowerCase(c);
        } else if (Character.isLowerCase(c)) {
            c = Character.toUpperCase(c);
        }
        return String.valueOf((char)c);
    }).collect(Collectors.joining());
}
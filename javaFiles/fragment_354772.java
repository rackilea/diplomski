private static String capitalizeFully(String str) {
    StringBuilder sb = new StringBuilder();
    boolean cnl = true; // <-- capitalize next letter.
    for (char c : str.toCharArray()) {
        if (cnl && Character.isLetter(c)) {
            sb.append(Character.toUpperCase(c));
            cnl = false;
        } else {
            sb.append(Character.toLowerCase(c));
        }
        if (Character.isWhitespace(c)) {
            cnl = true;
        }
    }
    return sb.toString();
}

public static void main(String[] args) {
    String source = "VESSEL ONE (L) INC";
    System.out.println(capitalizeFully(source));
}
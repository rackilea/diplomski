public static String java7(Iterable<Character> chars) {
    StringBuilder sb = new StringBuilder();
    for (Character c: chars) {
        sb.append(c);
    }
    return sb.toString();
}
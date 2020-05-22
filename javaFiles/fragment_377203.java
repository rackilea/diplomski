public static String getIdentifier(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        if ((i == 0 && Character.isJavaIdentifierStart(str.charAt(i))) || (i > 0 && Character.isJavaIdentifierPart(str.charAt(i))))
            sb.append(str.charAt(i));
        else
            sb.append((int)str.charAt(i));
    }
    return sb.toString();
}
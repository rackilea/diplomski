public static void main(String[] args) {
    String s = "123 sdkjh s;sdlkjh d";
    StringBuilder sb = new StringBuilder();
    if(!Character.isJavaIdentifierStart(s.charAt(0))) {
        sb.append("_");
    }
    for (char c : s.toCharArray()) {
        if(!Character.isJavaIdentifierPart(c)) {
            sb.append("_");
        } else {
            sb.append(c);
        }
    }

    System.out.println(sb);
}
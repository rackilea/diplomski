public static void main(String[] args) {
    for (char c⁯‮h = 0; c⁯‮h < Character.MAX_VALUE; c⁯‮h++) {
        if (Character.isJavaIdentifierPart(c⁯‮h) && !Character.isJavaIdentifierStart(c⁯‮h)) {
            System.out.printf("%04x <%s>%n", (int) c⁯‮h, "" + c⁯‮h);
        }
    }
}
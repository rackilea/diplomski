class NewLineTest {
    public static void main(String[] args) {
        String hasNewline = "this has a newline\n.";
        String noNewline = "this doesn't";

        System.out.println(hasNewline.contains("\n"));
        System.out.println(hasNewline.contains("\\n"));
        System.out.println(noNewline.contains("\n"));
        System.out.println(noNewline.contains("\\n"));

    }

}